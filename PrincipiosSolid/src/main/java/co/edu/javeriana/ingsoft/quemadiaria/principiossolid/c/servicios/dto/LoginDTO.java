package co.edu.javeriana.ingsoft.quemadiaria.principiossolid.c.servicios.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class LoginDTO {
    private String username;
    private String password;
}
