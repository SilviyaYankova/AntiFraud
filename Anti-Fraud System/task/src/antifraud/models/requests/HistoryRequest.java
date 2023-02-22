package antifraud.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class HistoryRequest {
    @NotNull
    Long transactionId;
    @NotNull
    String feedback;
}
