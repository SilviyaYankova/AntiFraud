package antifraud.services;

import antifraud.models.requests.HistoryRequest;
import antifraud.models.requests.TransactionAmountRequest;
import antifraud.models.responses.HistoryResponse;
import antifraud.models.responses.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse transaction(TransactionAmountRequest request);

    List<HistoryResponse> history( );

    List<HistoryResponse> getTransaction(String number);

    HistoryResponse feedback(HistoryRequest request);
}
