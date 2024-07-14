package br.com.gdarlan.hexagonal.adapters.out;

import br.com.gdarlan.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.gdarlan.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.gdarlan.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import br.com.gdarlan.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
