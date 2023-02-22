package antifraud.repositories;

import antifraud.models.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByNumberAndDateBetween(String number, LocalDateTime star, LocalDateTime end);

    List<TransactionEntity> findByNumber(String number);
}
