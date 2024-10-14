package br.com.tsuda.backend.controller;

import br.com.tsuda.backend.controller.request.SellerRequestDto;
import br.com.tsuda.backend.controller.response.SellerResponseDto;
import br.com.tsuda.backend.usecase.interfaces.SellerCreateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private SellerCreateUseCase sellerCreateUseCase;

    public SellerController(SellerCreateUseCase sellerCreateUseCase) {
        this.sellerCreateUseCase = sellerCreateUseCase;
    }

    @Operation(summary = "Create Seller")
    @PostMapping
    public SellerResponseDto create(@RequestBody @Valid SellerRequestDto request) {
        return sellerCreateUseCase.execute(request);
    }
}
