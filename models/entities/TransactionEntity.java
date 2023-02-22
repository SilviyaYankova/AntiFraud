package antifraud.models.entities;

import antifraud.models.enums.TransactionEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class TransactionEntity {
    TransactionEnum transactionEnum;
}
