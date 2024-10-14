package br.com.tsuda.backend.usecase;

import br.com.tsuda.backend.controller.request.SellerRequestDto;
import br.com.tsuda.backend.controller.response.SellerResponseDto;
import br.com.tsuda.backend.domain.converter.SellerConverter;
import br.com.tsuda.backend.domain.entity.Address;
import br.com.tsuda.backend.domain.entity.Contact;
import br.com.tsuda.backend.domain.entity.Seller;
import br.com.tsuda.backend.domain.repository.AddressRepository;
import br.com.tsuda.backend.domain.repository.ContactRepository;
import br.com.tsuda.backend.domain.repository.SellerRepository;
import br.com.tsuda.backend.usecase.interfaces.SellerCreateUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SellerCreateUseCaseImpl implements SellerCreateUseCase {

    private SellerRepository sellerRepository;
    private AddressRepository addressRepository;
    private ContactRepository contactRepository;

    public SellerCreateUseCaseImpl(SellerRepository sellerRepository, AddressRepository addressRepository,
                                   ContactRepository contactRepository) {
        this.sellerRepository = sellerRepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional
    public SellerResponseDto execute(SellerRequestDto request) {
        Address address = new Address();
        address.setLineAddress(request.address().lineAddress());
        address.setNumber(request.address().number());
        address.setPostalCode(request.address().postalCode());
        address.setNeighborhood(request.address().neighborhood());
        address.setCity(request.address().city());
        address.setState(request.address().state());
        address.setComplement(request.address().complement());
        addressRepository.save(address);

        List<Contact> contacts = request.contacts().stream()
                .map(c -> {
                    Contact contact = new Contact();
                    contact.setType(c.type());
                    contact.setValue(c.value());
                    return contactRepository.save(contact);
                })
                .collect(Collectors.toList());

        Seller seller = new Seller();
        seller.setName(request.name());
        seller.setBirthDate(request.birthDate());
        seller.setEmail(request.email());
        seller.setCpf(request.cpf());
        seller.setAddress(address);
        seller.setContacts(contacts);
        sellerRepository.save(seller);

        return SellerConverter.toResponse(seller);
    }
}
