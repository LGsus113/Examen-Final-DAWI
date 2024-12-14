package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDetailDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarUpdateDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.entity.Car;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.repository.CarRepository;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.service.ManageCarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageCarImpl implements ManageCarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();

        iterable.forEach(car -> {
            cars.add(new CarDto(
                    car.getCar_id(),
                    car.getModel(),
                    car.getYear(),
                    car.getMileage(),
                    car.getColor()
            ));
        });

        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);

        return optional.map(car -> new CarDetailDto(
                car.getCar_id(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicense_plate(),
                car.getOwner_name(),
                car.getOwner_contact(),
                car.getPurchase_date(),
                car.getMileage(),
                car.getEngine_type(),
                car.getColor(),
                car.getInsurance_company(),
                car.getInsurance_policy_number(),
                car.getRegistration_expiration_date(),
                car.getService_due_date()
        ));
    }

    @Override
    public boolean updateCar(CarUpdateDto carUpdateDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carUpdateDto.car_id());

        return optional.map(car -> {
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setOwner_name(carUpdateDto.owner_name());
            car.setColor(carUpdateDto.color());

            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);

        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDetailDto.car_id());

        if (optional.isPresent()) {
            return false;
        }

        Car car = new Car();
        car.setMake(carDetailDto.make());
        car.setModel(carDetailDto.model());
        car.setYear(carDetailDto.year());
        car.setVin(carDetailDto.vin());
        car.setLicense_plate(carDetailDto.license_plate());
        car.setOwner_name(carDetailDto.owner_name());
        car.setOwner_contact(carDetailDto.owner_contact());
        car.setPurchase_date(carDetailDto.purchase_date());
        car.setMileage(carDetailDto.mileage());
        car.setEngine_type(carDetailDto.engine_type());
        car.setColor(carDetailDto.color());
        car.setInsurance_company(carDetailDto.insurance_company());
        car.setInsurance_policy_number(carDetailDto.insurance_policy_number());
        car.setRegistration_expiration_date(carDetailDto.registration_expiration_date());
        car.setService_due_date(carDetailDto.service_due_date());

        carRepository.save(car);
        return true;
    }
}
