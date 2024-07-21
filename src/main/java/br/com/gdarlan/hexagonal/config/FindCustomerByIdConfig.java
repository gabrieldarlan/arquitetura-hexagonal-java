package br.com.gdarlan.hexagonal.config;

import br.com.gdarlan.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.gdarlan.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    //! NAS CLASSES DE BEAN USAR OS ADAPTERS 
    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
