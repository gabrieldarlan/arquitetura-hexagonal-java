package br.com.gdarlan.hexagonal.application.ports.in;

import br.com.gdarlan.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
