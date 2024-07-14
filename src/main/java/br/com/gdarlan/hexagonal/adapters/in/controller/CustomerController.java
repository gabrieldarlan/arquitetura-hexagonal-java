package br.com.gdarlan.hexagonal.adapters.in.controller;

import br.com.gdarlan.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.gdarlan.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.gdarlan.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.gdarlan.hexagonal.application.core.domain.Customer;
import br.com.gdarlan.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.gdarlan.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.gdarlan.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZiCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable("id") final String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final String id,
                                       @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZiCode());
        return ResponseEntity.noContent().build();
    }

}
