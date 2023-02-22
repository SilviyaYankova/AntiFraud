package antifraud.models.entities;

import antifraud.models.enums.RegionEnum;
import antifraud.models.enums.TransactionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions_history")
public class TransactionEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column
    Long amount;
    @Column
    String number;
    @Column
    String ip;
    @Column
    @Enumerated(value = EnumType.STRING)
    RegionEnum region;
    @Column
    LocalDateTime date;
    @Column
    String result;
    @Column
    String feedback;
}
