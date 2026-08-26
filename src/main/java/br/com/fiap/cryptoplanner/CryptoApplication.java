package br.com.fiap.cryptoplanner;

import br.com.fiap.cryptoplanner.planner.CryptoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(CryptoService.class)
public class CryptoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoApplication.class, args);
    }

}
