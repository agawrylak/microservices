package agawrylak.credit.controllers;

import agawrylak.credit.exceptions.NullMapException;
import agawrylak.credit.services.CreditService;
import agawrylak.credit.wrappers.CreditMap;
import agawrylak.credit.wrappers.CustomerMap;
import agawrylak.credit.wrappers.DataWrapper;
import agawrylak.credit.wrappers.ProductMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CreditController {
    private CreditService creditService;
    private RestTemplate restTemplate;

    private static final String productLink = "http://localhost:8081/product";
    private static final String customerLink = "http://localhost:8082/customer";

    public CreditController(CreditService creditService, RestTemplate restTemplate) {
        this.creditService = creditService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/credit/add")
    @ResponseStatus(HttpStatus.OK)
    public int createCredit(@RequestBody DataWrapper dataWrapper) {
        int creditId = creditService.addAndGetId(dataWrapper.getCreditDTO());
        restTemplate = new RestTemplate();
        String addProductLink = productLink + "/add/" + creditId;
        restTemplate.postForObject(addProductLink, dataWrapper.getProductDTO(), ResponseEntity.class);
        String addCustomerLink = customerLink + "/add/" + creditId;
        restTemplate.postForObject(addCustomerLink, dataWrapper.getCustomerDTO(), ResponseEntity.class);
        return creditId;
    }

    @GetMapping("/credit/get")
    @ResponseStatus(HttpStatus.OK)
    public List<DataWrapper> getCredits() {
        List<Integer> idList = creditService.getAllIds();
        CreditMap creditMap = creditService.getAll();
        ProductMap productMap = restTemplate.postForObject(productLink + "/get", idList, ProductMap.class);
        CustomerMap customerMap = restTemplate.postForObject(customerLink + "/get", idList, CustomerMap.class);

        if (productMap == null || customerMap == null) {
            throw new NullMapException();
        }

        List<DataWrapper> dataWrapperList = new ArrayList<>();
        for (Integer id : idList) {
            DataWrapper dataWrapper = new DataWrapper();
            dataWrapper.setCreditDTO(creditMap.getMap().get(id));
            dataWrapper.setCustomerDTO(customerMap.getMap().get(id));
            dataWrapper.setProductDTO(productMap.getMap().get(id));
            dataWrapperList.add(dataWrapper);
        }
        return dataWrapperList;
    }


}
