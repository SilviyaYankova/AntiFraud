package antifraud.services;

import antifraud.models.responses.DeleteCardResponse;
import antifraud.models.responses.StolenCardResponse;

import java.util.List;

public interface StolenCardService {
    StolenCardResponse addCard(String cardNumber);

    boolean cardIsStolen(String number);

    DeleteCardResponse delete(String number);

    List<StolenCardResponse> getAll();
}
