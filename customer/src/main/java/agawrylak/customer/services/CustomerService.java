package agawrylak.customer.services;

import agawrylak.customer.dtos.CustomerDTO;
import agawrylak.customer.models.Customer;
import agawrylak.customer.repositories.CustomerRepository;
import agawrylak.customer.wrappers.CustomerMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDTO add(CustomerDTO customerDTO, Integer id) {
        return convertToDTO(customerRepository.save(convertToEntityAndSetId(customerDTO, id)));
    }

    public CustomerMap findCustomersByIds(List<Integer> idList) {
        List<Customer> customerList = customerRepository.findByCreditIDIn(idList);
        HashMap<Integer, CustomerDTO> resultMap = new HashMap<>();
        for(Customer customer:customerList){
            resultMap.put(customer.getCreditID(),convertToDTO(customer));
        }
        CustomerMap customerMap = new CustomerMap();
        customerMap.setMap(resultMap);
        return customerMap;
    }

    private Customer convertToEntityAndSetId(CustomerDTO customerDTO, Integer id) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setCreditID(id);
        return customer;
    }

    private CustomerDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
