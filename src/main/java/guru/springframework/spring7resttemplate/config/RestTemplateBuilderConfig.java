package guru.springframework.spring7resttemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderConfig {

    @Value("${rest.template.rootUrl}")
    String rootUrl;

    @Value("${rest.template.username}")
    String username;

    @Value("${rest.template.password}")
    String password;
    
    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer){

        assert rootUrl!=null;

        return configurer.configure(new RestTemplateBuilder())
                            .basicAuthentication(username, password)
                            .uriTemplateHandler(new DefaultUriBuilderFactory(rootUrl));


    }
}
