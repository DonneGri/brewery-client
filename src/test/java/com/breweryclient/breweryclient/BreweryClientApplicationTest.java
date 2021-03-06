package com.breweryclient.breweryclient;

import com.breweryclient.breweryclient.web.client.BreweryClient;
import com.breweryclient.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){

        BeerDto newBeer =  BeerDto.builder().beerName("Rose Beer").build();

        URI uri = client.saveNewBeer(newBeer);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){

        BeerDto beerDto =  BeerDto.builder().beerName("Rose Beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);

    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

}