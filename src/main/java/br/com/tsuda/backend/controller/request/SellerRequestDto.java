package br.com.tsuda.backend.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record SellerRequestDto (
        @NotBlank(message = "Name is required!")
        String name,
        LocalDate birthDate,
        @Email(message = "Insert a valid e-mail!")
        String email,
        @CPF(message = "Insert a valid CPF!")
        String cpf,
        AddressRequestDto address,
        List<ContactRequestDto> contacts
){
}
