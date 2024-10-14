package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.controller.response.SellerResponseDto;
import br.com.tsuda.backend.domain.entity.Seller;

public class SellerConverter {

    public static SellerResponseDto toResponse(Seller entity) {
        return new SellerResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getCpf()
        );
    }
}
