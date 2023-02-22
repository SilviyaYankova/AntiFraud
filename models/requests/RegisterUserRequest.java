package antifraud.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter@Setter@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    @NotNull
    String name;
    @NotNull
    String username;
    @NotNull
    String password;
}
