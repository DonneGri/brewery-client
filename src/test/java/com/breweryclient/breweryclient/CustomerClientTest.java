package com.breweryclient.breweryclient;

import com.breweryclient.breweryclient.web.client.CustomerClient;
import com.breweryclient.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void testGetCustomerById(){
        CustomerDto dto = client.getCustomerId(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer(){

        CustomerDto newCustomer = CustomerDto.builder().name("Bob").build();

        URI uri = client.saveNewCustomer(newCustomer);
        assertNotNull(uri);


    }

    @Test
    void testUpdateCustomer(){

        CustomerDto customerDto = CustomerDto.builder().name("Jhon").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);

    }

    @Test
    void testDeleteCustomer(){

        client.deleteCustomer(UUID.randomUUID());
    }
}
