package br.com.tsuda.backend.controller.request;

import br.com.tsuda.backend.domain.enums.ContactTypeEnum;

public record ContactRequestDto (
        ContactTypeEnum type,
        String value
) {}
