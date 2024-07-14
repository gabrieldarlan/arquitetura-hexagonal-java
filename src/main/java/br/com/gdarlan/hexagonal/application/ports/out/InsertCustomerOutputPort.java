package br.com.gdarlan.hexagonal.application.ports.out;

import br.com.gdarlan.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
