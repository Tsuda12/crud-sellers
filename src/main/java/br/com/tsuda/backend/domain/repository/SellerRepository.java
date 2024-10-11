package br.com.tsuda.backend.domain.repository;

import br.com.tsuda.backend.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
