package antifraud.services;

import antifraud.models.entities.UserEntity;
import antifraud.models.responses.ChangeUserRoleResponse;
import antifraud.models.responses.DeleteUserResponse;
import antifraud.models.responses.RegisterUserResponse;
import antifraud.models.responses.ChangeUserAccessResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    RegisterUserResponse register(String name, String username, String password);

    boolean usernameAlreadyExists(String username);

    List<RegisterUserResponse> getAllUsers();

    DeleteUserResponse delete(String username);

    Optional<UserEntity> findUserByUsername(String username);

    ChangeUserRoleResponse changeRole(String username, String userRole);

    ChangeUserAccessResponse changeAccess(String username, String operation);

    boolean checkIfRoleExist(String role);

    Optional<UserEntity> getLoggedUser();
}
