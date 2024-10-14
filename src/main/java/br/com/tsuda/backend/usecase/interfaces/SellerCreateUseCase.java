package br.com.tsuda.backend.usecase.interfaces;

import br.com.tsuda.backend.controller.request.SellerRequestDto;
import br.com.tsuda.backend.controller.response.SellerResponseDto;

public interface SellerCreateUseCase {
    SellerResponseDto execute(SellerRequestDto request);
}
