package antifraud.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransactionAmountRequest {
    @NotNull
    @Min(1L)
    Long amount;
    @NotNull
    String ip;
    @NotNull
    String number;
    @NotNull
    String region;
    @NotNull
    LocalDateTime date;
}
