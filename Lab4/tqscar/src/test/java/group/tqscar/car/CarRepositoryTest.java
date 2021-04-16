package group.tqscar.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindCarByName_thenReturnAlexEmployee() {
        Car bmw = new Car("118d", "BMW");
        entityManager.persistAndFlush(bmw); //ensure data is persisted at this point

        Car found = carRepository.findByName(bmw.getName());
        assertThat( found ).isEqualTo(bmw);
    }

    @Test
    public void whenInvalidCarName_thenReturnNull() {
        Car invisible = carRepository.findByName("Invisible");
        assertThat(invisible).isNull();

    }
}