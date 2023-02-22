package antifraud.services.impl;

import antifraud.models.entities.StolenCardEntity;
import antifraud.models.responses.CardResponse;
import antifraud.models.responses.DeleteCardResponse;
import antifraud.repositories.StolenCardRepository;
import antifraud.services.CardService;
import antifraud.services.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {
    final StolenCardRepository stolenCardRepository;
    final Validator validator;

    @Override
    public CardResponse addCard(String cardNumber) {
        validator.validateCardNumber(cardNumber);
        if (cardIsStolen(cardNumber)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        StolenCardEntity entity = new StolenCardEntity();
        entity.setNumber(cardNumber);
        stolenCardRepository.save(entity);
        return new CardResponse(entity.getId(), entity.getNumber());
    }

    @Override
    public boolean cardIsStolen(String number) {
        return stolenCardRepository.findByNumber(number).isPresent();
    }

    @Override
    public DeleteCardResponse delete(String number) {
        validator.validateCardNumber(number);
        if (!cardIsStolen(number)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<StolenCardEntity> entity = stolenCardRepository.findByNumber(number);
        stolenCardRepository.delete(entity.get());
        return new DeleteCardResponse("Card " + number + " successfully removed!");
    }

    @Override
    public List<CardResponse> getAll() {
        return stolenCardRepository.findAll()
                                   .stream()
                                   .map(c -> new CardResponse(c.getId(), c.getNumber()))
                                   .collect(Collectors.toList());
    }

    @Override
    public boolean cardIsBlacklisted(String number) {
        return stolenCardRepository.findByNumber(number).isPresent();
    }
}
