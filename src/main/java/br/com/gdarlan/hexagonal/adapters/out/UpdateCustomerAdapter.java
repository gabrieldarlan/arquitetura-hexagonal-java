package br.com.gdarlan.hexagonal.adapters.out;

import br.com.gdarlan.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.gdarlan.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.gdarlan.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import br.com.gdarlan.hexagonal.application.ports.out.UpdateCustomerOuputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOuputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
