package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.dto;

public record CarUpdateDto(
        Integer car_id,
        String make,
        String model,
        Integer year,
        String owner_name,
        String color
) {
}
