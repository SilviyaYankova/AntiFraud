package antifraud.services;

import antifraud.models.requests.TransactionAmountRequest;
import antifraud.models.responses.TransactionResponse;

public interface TransactionService {
    TransactionResponse transaction(TransactionAmountRequest request);
}
