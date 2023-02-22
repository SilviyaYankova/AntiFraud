package antifraud.controllers;

import antifraud.models.requests.AddStolenCardRequest;
import antifraud.models.responses.CardResponse;
import antifraud.models.responses.DeleteCardResponse;
import antifraud.services.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/antifraud")
@RequiredArgsConstructor
@RestController
public class StolenCardController {
    final CardService cardService;

    @PostMapping("/stolencard")
    CardResponse addStolenCard(@RequestBody AddStolenCardRequest request) {
        return cardService.addCard(request.getNumber());
    }

    @DeleteMapping("stolencard/{number}")
    DeleteCardResponse delete(@PathVariable String number) {
        return cardService.delete(number);
    }

    @GetMapping("/stolencard")
    List<CardResponse> getAll() {
        return cardService.getAll();
    }
}
