package antifraud.controllers;

import antifraud.models.requests.HistoryRequest;
import antifraud.models.requests.TransactionAmountRequest;
import antifraud.models.responses.HistoryResponse;
import antifraud.models.responses.TransactionResponse;
import antifraud.services.TransactionService;
import antifraud.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/api/antifraud/")
@RequiredArgsConstructor
@RestController
public class TransactionController {
    final TransactionService transactionService;
    final UserService userService;

    @PreAuthorize("hasRole('MERCHANT')")
    @PostMapping("/transaction")
    TransactionResponse transaction(@RequestBody @Valid TransactionAmountRequest request) {
        return transactionService.transaction(request);
    }

    @PreAuthorize("hasRole('SUPPORT')")
    @PutMapping("/transaction")
    HistoryResponse history(@RequestBody @Valid HistoryRequest request) {
        return transactionService.feedback(request);
    }

    @PreAuthorize("hasRole('SUPPORT')")
    @GetMapping("/history")
    List<HistoryResponse> getHistory() {
        return transactionService.history();
    }

    @PreAuthorize("hasRole('SUPPORT')")
    @GetMapping("/history/{number}")
    List<HistoryResponse> getTransaction(@PathVariable String number) {
        return transactionService.getTransaction(number);
    }
}
