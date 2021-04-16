package group.tqscar.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureTestDatabase
public class CarControllerTemplateTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }


    @Test
    public void whenValidInput_thenCreateCar() {
        Car ferrari = new Car("Italia", "Ferrari");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", ferrari, Car.class);

        Car found = repository.findByName(ferrari.getName());
        assertThat(found).extracting(Car::getName).isEqualTo(ferrari.getName());
    }

    @Test
    public void givenCar_whenGetCars_thenStatus200()  {
        Car bmw = new Car("118d", "BMW");
        repository.saveAndFlush(bmw);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+randomServerPort+"/api/car")
                .queryParam("name", "118d");

        ResponseEntity<Car> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo(bmw.getName());
    }


}