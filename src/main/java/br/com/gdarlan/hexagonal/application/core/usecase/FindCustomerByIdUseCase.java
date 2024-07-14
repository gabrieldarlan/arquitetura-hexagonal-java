package br.com.gdarlan.hexagonal.application.core.usecase;

import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import br.com.gdarlan.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.gdarlan.hexagonal.application.ports.out.FindCustomerByIdOutputPort;


public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        //! CRIAR MINHA EXCEPTION DEPOIS
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
