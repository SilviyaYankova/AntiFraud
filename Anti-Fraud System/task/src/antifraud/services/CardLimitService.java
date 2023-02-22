package antifraud.services;

import antifraud.models.entities.CardLimitEntity;

public interface CardLimitService {

    CardLimitEntity findByNumber(String number);

    void save(CardLimitEntity card);
}
