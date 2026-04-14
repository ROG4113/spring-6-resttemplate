package guru.springframework.spring7resttemplate.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import guru.springframework.spring7resttemplate.model.BeerDTO;

@SpringBootTest
public class BeerClientImplTest {
    @Autowired
    BeerClientImpl beerClient;

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