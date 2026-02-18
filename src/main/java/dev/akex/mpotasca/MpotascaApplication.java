package dev.akex.mpotasca;

import dev.akex.mpotasca.repositories.ConflictRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.ConcurrencyFailureException;

@SpringBootApplication
public class MpotascaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpotascaApplication.class, args);
    }
}
