package br.com.tsuda.backend.domain.repository;

import br.com.tsuda.backend.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
