package br.com.gdarlan.hexagonal.adapters;

import br.com.gdarlan.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.gdarlan.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.gdarlan.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import br.com.gdarlan.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
