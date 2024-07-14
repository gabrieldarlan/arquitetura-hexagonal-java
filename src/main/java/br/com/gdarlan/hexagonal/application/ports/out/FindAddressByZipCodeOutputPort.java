package br.com.gdarlan.hexagonal.application.ports.out;

import br.com.gdarlan.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
