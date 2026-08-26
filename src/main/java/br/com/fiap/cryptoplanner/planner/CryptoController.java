package br.com.fiap.cryptoplanner.planner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
public class CryptoController {

    private final RulesService rulesService;

    public record PlannerResponse(String result){}
    public record PlannerRequest(String activity) {}

    @GetMapping
    public PlannerResponse doPlannerFrom(PlannerRequest request) {
        return new PlannerResponse(
                rulesService.getActivityPlanner(request.activity)
        );
    }
}
