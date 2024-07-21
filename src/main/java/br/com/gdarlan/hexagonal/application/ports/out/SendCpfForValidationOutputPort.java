package br.com.gdarlan.hexagonal.application.ports.out;

public interface SendCpfForValidationOutputPort {
    void send(String cpf);
}
