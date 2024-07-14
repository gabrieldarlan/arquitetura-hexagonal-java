package br.com.gdarlan.hexagonal.application.ports.out;

import br.com.gdarlan.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);
}
