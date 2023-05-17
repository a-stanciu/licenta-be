package alin.licenta.be.entities;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;

    private String password;
}
