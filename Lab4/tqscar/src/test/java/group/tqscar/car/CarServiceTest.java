package group.tqscar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    // lenient is required because we load some expectations in the setup
    // that are not used in all the tests. As an alternative, the expectations
    // could move into each test method and be trimmed: no need for lenient
    @Mock( lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setUp() {
        Car bmw = new Car("118d", "BMW");
        Car mclaren = new Car("F1", "Mclaren");
        Car nissan = new Car("GTR", "Nissan");

        Mockito.when(carRepository.findByName(bmw.getName())).thenReturn(bmw);
        Mockito.when(carRepository.findByName(mclaren.getName())).thenReturn(mclaren);
        Mockito.when(carRepository.findByName(nissan.getName())).thenReturn(nissan);
        Mockito.when(carRepository.findByName("wrong_name")).thenReturn(null);
    }

    @Test
    public void whenValidName_thenCarShouldBeFound() {
        String[] cars = {"118d", "F1", "GTR"};
        for (String carname : cars) {
            Car found = carService.getCarDetails(carname);
            assertThat(found.getName()).isEqualTo(carname);
        }
    }

    @Test
    public void whenInvalidName_thenCarShouldNotBeFound() {
        String car_name = "wrongcar";
        Car found = carService.getCarDetails(car_name);
        assertThat(found).isNull();

        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByName(car_name);
        Mockito.reset(carRepository);
    }

}
