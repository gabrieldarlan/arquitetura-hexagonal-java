package br.com.gdarlan.hexagonal.config;

import br.com.gdarlan.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.gdarlan.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import br.com.gdarlan.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    //! NAS CLASSES DE BEAN USAR OS ADAPTERS 
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            //!Quando foi input usar a propria usecase 
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdOutputPort deleteCustomerByIdUseCase
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdUseCase);
    }
}
