package guru.springframework.spring7resttemplate.client;

import java.util.Map;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.spring7resttemplate.model.BeerDTO;
import guru.springframework.spring7resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String GET_BEER_PATH="/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {
        
        RestTemplate restTemplate=restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder=UriComponentsBuilder.fromPath(GET_BEER_PATH);

        ResponseEntity<BeerDTOPageImpl> response=
            restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);
        
        // ResponseEntity<String> stringResponse=
        //     restTemplate.getForEntity(BASE_URL+GET_BEER_PATH, String.class);
        
        // ResponseEntity<Map> mapResponse=
        //     restTemplate.getForEntity(BASE_URL+GET_BEER_PATH, Map.class);
        
        //     ResponseEntity<JsonNode> jsonResponse=
        //     restTemplate.getForEntity(BASE_URL+GET_BEER_PATH, JsonNode.class);

        //     jsonResponse.getBody().findPath("content").forEach(node->{
        //         System.out.println(node.get("beerName").asText());
        //     });

        // System.out.println(stringResponse.getBody());

        return response.getBody();
    }

}