package antifraud.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class ChangeUserRoleRequest {
    String username;
    String role;
}
