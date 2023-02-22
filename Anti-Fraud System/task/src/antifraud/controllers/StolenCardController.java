package antifraud.controllers;

import antifraud.models.requests.AddStolenCardRequest;
import antifraud.models.responses.DeleteCardResponse;
import antifraud.models.responses.StolenCardResponse;
import antifraud.services.StolenCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('SUPPORT')")
@RequestMapping("/api/antifraud")
@RequiredArgsConstructor
@RestController
public class StolenCardController {
    final StolenCardService stolenCardService;

    @PostMapping("/stolencard")
    StolenCardResponse addStolenCard(@RequestBody AddStolenCardRequest request) {
        return stolenCardService.addCard(request.getNumber());
    }

    @DeleteMapping("stolencard/{number}")
    DeleteCardResponse delete(@PathVariable String number) {
        return stolenCardService.delete(number);
    }

    @GetMapping("/stolencard")
    List<StolenCardResponse> getAll() {
        return stolenCardService.getAll();
    }
}
