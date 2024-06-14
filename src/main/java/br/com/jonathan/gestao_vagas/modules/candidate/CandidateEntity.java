package br.com.jonathan.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Email(message = "O campo (email) deve conter um e-mail válido")
    private String email;

    @Length(min = 6, max = 100, message = "A senha deve conter entre 6 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;
}