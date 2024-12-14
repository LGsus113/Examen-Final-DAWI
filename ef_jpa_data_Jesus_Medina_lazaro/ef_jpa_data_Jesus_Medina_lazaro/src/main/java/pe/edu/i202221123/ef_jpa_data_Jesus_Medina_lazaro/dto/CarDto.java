package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto;

public record CarDto(
        Integer car_id,
        String model,
        Integer year,
        Integer mileage,
        String color
) {
}
