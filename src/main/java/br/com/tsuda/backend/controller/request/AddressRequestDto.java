package br.com.tsuda.backend.controller.request;

public record AddressRequestDto (
    String lineAddress,
    String number,
    String postalCode,
    String neighborhood,
    String city,
    String state,
    String complement
) {}
