package group.tqscar.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepo;

    public Car save(Car car) {
        return carRepo.save(car);
    }

    public Car getCarDetails(String name){
        return carRepo.findByName(name);
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }
}