package br.com.fiap.cryptoplanner.planner;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CryptoResponse(
        String id,
        String name,
        @JsonProperty("market_data") MarketDataResponse marketData
) {}