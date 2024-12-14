package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.response;

import pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto.CarDetailDto;

public record FindCarDetailResponse(
        String code,
        String error,
        CarDetailDto car
) {
}
