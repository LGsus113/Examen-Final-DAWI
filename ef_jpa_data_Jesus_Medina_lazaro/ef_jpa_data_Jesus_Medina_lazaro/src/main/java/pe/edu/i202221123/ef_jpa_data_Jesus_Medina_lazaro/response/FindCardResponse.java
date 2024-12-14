package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.response;

import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDto;

import java.util.List;

public record FindCardResponse(
        String code,
        String error,
        Iterable<CarDto> cars
) {
}
