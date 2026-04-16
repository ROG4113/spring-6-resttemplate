package guru.springframework.spring7resttemplate.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.HttpClientErrorException;

import guru.springframework.spring7resttemplate.model.BeerDTO;
import guru.springframework.spring7resttemplate.model.BeerStyle;

@SpringBootTest
public class BeerClientImplTest {
    @Autowired
    BeerClientImpl beerClient;

    @Test
    void testDeleteBeer(){
        BeerDTO newDto=BeerDTO.builder()
                                .price(new BigDecimal("10.99"))
                                .beerName("Mango Bobs 2")
                                .beerStyle(BeerStyle.IPA)
                                .quantityOnHand(500)
                                .upc("12345")
                                .build();

        BeerDTO beerDto=beerClient.createBeer(newDto);

        beerClient.deleteBeer(beerDto.getId());

        assertThrows(HttpClientErrorException.class, ()->{
            // should throw error if deleted
            beerClient.getBeerById(beerDto.getId());
        });
    }

    @Test
    void testUpdateBeer(){

        BeerDTO newDto=BeerDTO.builder()
                                .price(new BigDecimal("10.99"))
                                .beerName("mango Bobs 2")
                                .beerStyle(BeerStyle.IPA)
                                .quantityOnHand(500)
                                .upc("12345")
                                .build();

        BeerDTO beerDto=beerClient.createBeer(newDto);

        final String newName="Mango Bobs 3";
        beerDto.setBeerName(newName);
        BeerDTO updatedBeer=beerClient.updateBeer(beerDto);

        assertEquals(newName, updatedBeer.getBeerName());
    }

    @Test
    void testCreateBeer(){
        BeerDTO newDto=BeerDTO.builder()
                                .beerName("Bro Code")
                                .beerStyle(BeerStyle.IPA)
                                .price(new BigDecimal("10.99"))
                                .quantityOnHand(500)
                                .upc("12345")
                                .build();

        BeerDTO savedDto=beerClient.createBeer(newDto);
        assertNotNull(savedDto);
    }

    @Test
    void testGetBeerById(){
        Page<BeerDTO> beerDTOs=beerClient.listBeers(null);

        BeerDTO dto=beerDTOs.getContent().get(0);

        BeerDTO byId=beerClient.getBeerById(dto.getId());

        assertNotNull(byId);
    }

    @Test
    void testListBeersNoBeerName() {
        beerClient.listBeers(null);
    }

    @Test
    void testListBeers() {
        beerClient.listBeers("ALE");
    }
}