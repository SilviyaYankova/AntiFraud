package antifraud.controllers;

import antifraud.models.requests.TransactionAmountRequest;
import antifraud.models.responses.TransactionResponse;
import antifraud.services.TransactionService;
import antifraud.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TransactionController {
    final TransactionService transactionService;
    final UserService userService;

    @PostMapping("/api/antifraud/transaction")
    TransactionResponse transaction(@RequestBody @Valid TransactionAmountRequest request) {
        return transactionService.transaction(request);
    }
}
