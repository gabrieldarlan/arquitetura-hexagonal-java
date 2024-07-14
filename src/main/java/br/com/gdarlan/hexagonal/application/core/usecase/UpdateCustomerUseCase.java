package br.com.gdarlan.hexagonal.application.core.usecase;

import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import br.com.gdarlan.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.gdarlan.hexagonal.application.ports.in.UpdateCustomerInputPort;
import br.com.gdarlan.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.gdarlan.hexagonal.application.ports.out.UpdateCustomerOuputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOuputPort updateCustomerOuputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOuputPort updateCustomerOuputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOuputPort = updateCustomerOuputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOuputPort.update(customer);
    }
}
