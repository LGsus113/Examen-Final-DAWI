package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDetailDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarUpdateDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.response.*;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.service.ManageCarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class ManageController {
    @Autowired
    ManageCarService manageCarService;

    @GetMapping("/all")
    public FindCardResponse findUser() {
        try {
            List<CarDto> cars = manageCarService.getAllCars();

            if (cars.isEmpty()) {
                return new FindCardResponse("02", "Cars not found", null);
            }

            return new FindCardResponse("01", null, cars);
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCardResponse("99", "Error ocurred: " + e.getMessage(), null);
        }
    }

    @GetMapping("/detail")
    public FindCarDetailResponse findCar(@RequestParam String id) {
        try {
            Optional<CarDetailDto> optional = manageCarService.getCarById(Integer.parseInt(id));

            return optional.map(car ->
                    new FindCarDetailResponse("01", null, car)
            ).orElse(
                    new FindCarDetailResponse("02", "Car not found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarDetailResponse("99", "Car not found" + e.getMessage(), null);
        }
    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarUpdateDto carUpdateDto) {
        try {
            if (manageCarService.updateCar(carUpdateDto)) {
                return new UpdateCarResponse("01", null);
            } else {
                return new UpdateCarResponse("02", "Car not found");
            }
        } catch (Exception e) {
            return new UpdateCarResponse("99", "Error ocurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {
        try {
            if (manageCarService.deleteCarById(Integer.parseInt(id))) {
                return new DeleteCarResponse("01", null);
            } else {
                return new DeleteCarResponse("02", "Car not found");
            }
        } catch (Exception e) {
            return new DeleteCarResponse("99", "Error ocurred: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {
        try {
            if (manageCarService.addCar(carDetailDto)) {
                return new CreateCarResponse("01", null);
            } else {
                return new CreateCarResponse("02", "Car already exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Error ocurred: " + e.getMessage());
        }
    }
}
