package br.com.fiap.cryptoplanner.planner;

import org.springframework.stereotype.Service;

@Service
public class RulesService {

    private final CryptoService cryptoService;

    public RulesService(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    public String getActivityPlanner(String activity) {
        String coinId = switch (activity.toLowerCase()) {
            case "comprar bitcoin" -> "bitcoin";
            case "vender ethereum" -> "ethereum";
            case "investir em dogecoin" -> "dogecoin";
            default -> throw new IllegalArgumentException("Atividade desconhecida");
        };

        CryptoResponse response = cryptoService.getCoinById(coinId);
        double variation = response.marketData().priceChangePercentage24h();

        if (activity.equalsIgnoreCase("Comprar Bitcoin")) {
            if (variation > 5.0) return "Não recomendado (pode estar supervalorizado).";
            if (variation < -5.0) return "Bom momento para comprar Bitcoin, o preço caiu nas últimas 24h.";
            return "Preço estável, sem sinal forte.";
        }
        else if (activity.equalsIgnoreCase("Vender Ethereum")) {
            if (variation < -5.0) return "Não recomendado vender, espere recuperação.";
            if (variation > 5.0) return "Bom momento pra vender.";
            return "Preço estável, sem sinal forte.";
        }
        else if (activity.equalsIgnoreCase("Investir em Dogecoin")) {
            if (variation > 10.0) return "Cuidado, alta volatilidade, risco elevado.";
            return "Volatilidade normal, mas é ativo de altíssimo risco.";
        }

        return "Análise indisponível.";
    }
}
