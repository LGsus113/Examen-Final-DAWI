package pe.edu.i202221123.ef_jpa_data_Jesus_Medina_lazaro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer car_id;
    private String make;
    private String model;
    private Integer year;
    private String vin;
    private String license_plate;
    private String owner_name;
    private String owner_contact;
    private Date purchase_date;
    private Integer mileage;
    private String engine_type;
    private String color;
    private String insurance_company;
    private String insurance_policy_number;
    private Date registration_expiration_date;
    private Date service_due_date;
}