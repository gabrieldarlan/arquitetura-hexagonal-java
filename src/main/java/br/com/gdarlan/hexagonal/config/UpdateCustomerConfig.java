package br.com.gdarlan.hexagonal.config;

import br.com.gdarlan.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.gdarlan.hexagonal.adapters.out.UpdateCustomerAdapter;
import br.com.gdarlan.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import br.com.gdarlan.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    //! NAS CLASSES DE BEAN USAR OS ADAPTERS 
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            //!Quando foi input usar a propria usecase 
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter

    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
