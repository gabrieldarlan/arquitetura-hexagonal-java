package br.com.gdarlan.hexagonal.application.ports.in;

import br.com.gdarlan.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
