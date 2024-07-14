package br.com.gdarlan.hexagonal.adapters.out.repository.mapper;

import br.com.gdarlan.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
