package antifraud.repositories;

import antifraud.models.entities.SuspiciousIPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuspiciousIPRepository extends JpaRepository<SuspiciousIPEntity, Long> {
    Optional<SuspiciousIPEntity> findByIp(String ip);
}
