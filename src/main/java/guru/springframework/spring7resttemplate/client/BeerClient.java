package guru.springframework.spring7resttemplate.client;

import java.util.UUID;

import org.springframework.data.domain.Page;

import guru.springframework.spring7resttemplate.model.BeerDTO;

public interface BeerClient {
    Page<BeerDTO> listBeers(String beerName);

    BeerDTO getBeerById(UUID beerId);

    BeerDTO createBeer(BeerDTO newDto);

    BeerDTO updateBeer(BeerDTO beerDto);

    void deleteBeer(UUID beerId);
}
