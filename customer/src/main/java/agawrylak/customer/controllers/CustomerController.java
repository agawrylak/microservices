package agawrylak.customer.controllers;

import agawrylak.customer.dtos.CustomerDTO;
import agawrylak.customer.services.CustomerService;
import agawrylak.customer.wrappers.CustomerMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;
    private static final String customerLink = "/customer";

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(customerLink + "/add/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void addCustomer(@RequestBody final CustomerDTO customerDTO, @PathVariable final int id) {
        customerService.add(customerDTO, id);
    }

    @PostMapping(customerLink + "/get")
    public CustomerMap getCustomers(@RequestBody List<Integer> idList) {
        return customerService.findCustomersByIds(idList);
    }
}
