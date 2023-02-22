package antifraud.services.impl;

import antifraud.models.entities.CardLimitEntity;
import antifraud.repositories.CardLimitRepository;
import antifraud.services.CardLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardLimitServiceImpl implements CardLimitService {
    private final CardLimitRepository cardLimitRepository;

    @Override
    public CardLimitEntity findByNumber(String number) {
        return cardLimitRepository.findByNumber(number);
    }

    @Override
    public void save(CardLimitEntity card) {
        cardLimitRepository.save(card);
    }
}
