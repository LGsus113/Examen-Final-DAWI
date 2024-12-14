package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.service;

import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDetailDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDto;
import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageCarService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarUpdateDto carUpdateDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
