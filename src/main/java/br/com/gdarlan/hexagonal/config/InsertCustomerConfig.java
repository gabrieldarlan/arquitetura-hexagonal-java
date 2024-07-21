package br.com.gdarlan.hexagonal.config;

import br.com.gdarlan.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.gdarlan.hexagonal.adapters.out.InsertCustomerAdapter;
import br.com.gdarlan.hexagonal.adapters.out.SendCpfForValidationAdapter;
import br.com.gdarlan.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    //! NAS CLASSES DE BEAN USAR OS ADAPTERS
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationOutputPort
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationOutputPort);
    }
}
