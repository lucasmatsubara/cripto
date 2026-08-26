package br.com.fiap.cryptoplanner.planner;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
        url="https://api.coingecko.com",
        accept = "application/json"
)

public interface CryptoService {

    @GetExchange("/api/v3/coins/{id}")
    CryptoResponse getCoinById(@PathVariable("id") String id);
}
