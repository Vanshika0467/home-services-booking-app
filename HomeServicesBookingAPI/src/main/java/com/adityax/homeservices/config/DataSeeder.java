package com.adityax.homeservices.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adityax.homeservices.entity.ServiceItem;
import com.adityax.homeservices.repository.ServiceRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedServices(ServiceRepository repository) {

        return args -> {

            if (repository.count() == 0) {

                List<ServiceItem> services = List.of(

                    new ServiceItem(
                        "Home Cleaning",
                        "General home cleaning for rooms and kitchen.",
                        new BigDecimal("799.00"),
                        4.6
                    ),

                    new ServiceItem(
                        "Plumbing",
                        "Tap repair and water leakage services.",
                        new BigDecimal("499.00"),
                        4.4
                    ),

                    new ServiceItem(
                        "Electrician",
                        "Electrical repairs and light fitting.",
                        new BigDecimal("399.00"),
                        4.5
                    ),

                    new ServiceItem(
                        "AC Service",
                        "Air conditioner cleaning and maintenance.",
                        new BigDecimal("999.00"),
                        4.3
                    ),

                    new ServiceItem(
                        "Carpentry",
                        "Door, furniture and shelf repairs.",
                        new BigDecimal("599.00"),
                        4.2
                    ),

                    new ServiceItem(
                        "Pest Control",
                        "Home pest inspection and treatment.",
                        new BigDecimal("1299.00"),
                        4.1
                    ),

                    new ServiceItem(
                        "Appliance Repair",
                        "Repair services for household appliances.",
                        new BigDecimal("699.00"),
                        4.0
                    ),

                    new ServiceItem(
                        "Painting",
                        "Wall painting and touch-up services.",
                        new BigDecimal("1499.00"),
                        4.4
                    )
                );

                repository.saveAll(services);

                System.out.println("8 Home Services inserted successfully!");
            }
        };
    }
}
