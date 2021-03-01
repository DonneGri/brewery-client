package com.breweryclient.breweryclient.web.client;

import com.breweryclient.breweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1="/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost){
        this.apihost = apihost;
    }

    public CustomerDto getCustomerId(UUID uuid){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(@RequestBody CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){

        restTemplate.put(apihost+CUSTOMER_PATH_V1+"/"+uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){

        restTemplate.delete(apihost+CUSTOMER_PATH_V1+"/"+uuid.toString());
    }
}
