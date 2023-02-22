package antifraud.services;

import antifraud.models.requests.AddStolenCardRequest;
import antifraud.models.responses.CardResponse;
import antifraud.models.responses.DeleteCardResponse;

import java.util.List;

public interface CardService {
    CardResponse addCard(String cardNumber);

    boolean cardIsStolen(String number);

    DeleteCardResponse delete(String number);

    List<CardResponse> getAll();

    boolean cardIsBlacklisted(String number);
}
