package com.akaws.connect;

import com.akaws.connect.model.City;
import com.akaws.connect.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
@ComponentScan
public class Application implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    private CityRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        /*
         * clear repository before adding list of connected cities
         */
        repository.deleteAll();

        Resource resource = resourceLoader.getResource("classpath:city.txt");
        InputStream inputStream = resource.getInputStream();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            while (line != null){
                LOGGER.info(line);
                String[] cities =  line.split(",");
                /*
                 * Add city to repository
                 */
                repository.save(new City(cities[0].trim(), cities[1].trim()));
                repository.save(new City(cities[1].trim(), cities[0].trim()));
                line = br.readLine();
            }

        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
    }
}
