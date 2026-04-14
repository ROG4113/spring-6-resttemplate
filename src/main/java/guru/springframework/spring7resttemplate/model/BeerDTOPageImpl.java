package guru.springframework.spring7resttemplate.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true, value = "pageable")
public class BeerDTOPageImpl<T> extends PageImpl {

    public BeerDTOPageImpl(@JsonProperty("content") List<T> content,
                        @JsonProperty("number") int page,
                        @JsonProperty("size") int size,
                        @JsonProperty("totalElements") long total){
                            super(content, PageRequest.of(page, size), total);
                        }

    public BeerDTOPageImpl(List<T> content, Pageable pageable, long total){
        super(content, pageable, total);
    }

    public BeerDTOPageImpl(List<T> content){
        super(content);
    }
}
