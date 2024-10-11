package br.com.tsuda.backend.domain.repository;

import br.com.tsuda.backend.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
