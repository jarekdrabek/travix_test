package drabek.jaroslaw;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new Jackson2ObjectMapperBuilder().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}