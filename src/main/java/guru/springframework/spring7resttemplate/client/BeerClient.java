package guru.springframework.spring7resttemplate.client;

import java.util.UUID;

import org.springframework.data.domain.Page;

import guru.springframework.spring7resttemplate.model.BeerDTO;
import guru.springframework.spring7resttemplate.model.BeerStyle;

public interface BeerClient {
    Page<BeerDTO> listBeers(String beerName,BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    Page<BeerDTO> listBeers();

    BeerDTO getBeerById(UUID beerId);

    BeerDTO createBeer(BeerDTO newDto);

    BeerDTO updateBeer(BeerDTO beerDto);

    void deleteBeer(UUID beerId);
}
