package br.com.fiap.cryptoplanner.planner;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MarketDataResponse(
        @JsonProperty("current_price") CurrentPriceResponse currentPrice,
        @JsonProperty("price_change_percentage_24h") double priceChangePercentage24h
) {}
