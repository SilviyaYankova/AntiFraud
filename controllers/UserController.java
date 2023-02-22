package antifraud.controllers;

import antifraud.models.entities.UserEntity;
import antifraud.models.enums.RoleEnum;
import antifraud.models.requests.ChangeUserRoleRequest;
import antifraud.models.requests.RegisterUserRequest;
import antifraud.models.requests.ChangeUserAccessRequest;
import antifraud.models.responses.ChangeUserRoleResponse;
import antifraud.models.responses.DeleteUserResponse;
import antifraud.models.responses.RegisterUserResponse;
import antifraud.models.responses.ChangeUserAccessResponse;
import antifraud.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class UserController {
    final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    RegisterUserResponse register(@RequestBody @Valid RegisterUserRequest request) {
        return userService.register(request.getName(), request.getUsername(), request.getPassword());
    }

    @GetMapping("/list")
    List<RegisterUserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/user/{username}")
    DeleteUserResponse delete(@PathVariable String username) {
        return userService.delete(username);
    }

    @PutMapping("/access")
    ChangeUserAccessResponse access(@RequestBody ChangeUserAccessRequest request) {
        ChangeUserAccessResponse response = userService.changeAccess(request.getUsername(), request.getOperation());
        return new ChangeUserAccessResponse(response.getStatus());
    }

    @PutMapping("/role")
    ChangeUserRoleResponse role(@RequestBody ChangeUserRoleRequest request) {
        return userService.changeRole(request.getUsername(), request.getRole());

    }
}
