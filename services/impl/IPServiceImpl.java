package antifraud.services.impl;

import antifraud.models.entities.SuspiciousIPEntity;
import antifraud.models.entities.UserEntity;
import antifraud.models.enums.RoleEnum;
import antifraud.models.responses.DeleteSuspiciousIPResponse;
import antifraud.models.responses.SuspiciousIPResponse;
import antifraud.repositories.SuspiciousIPRepository;
import antifraud.services.IPService;
import antifraud.services.UserService;
import antifraud.services.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IPServiceImpl implements IPService {
    final SuspiciousIPRepository suspiciousIPRepository;
    final UserService userService;
    final Validator validator;

    @Override
    public SuspiciousIPResponse addSuspiciousIP(String ip) {
        if (ipIsBlacklisted(ip)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        validator.validateIp(ip);
        SuspiciousIPEntity entity = new SuspiciousIPEntity();
        entity.setIp(ip);
        suspiciousIPRepository.save(entity);
        return new SuspiciousIPResponse(entity.getId(), entity.getIp());
    }

    @Override
    public boolean ipIsBlacklisted(String ip) {
        return suspiciousIPRepository.findByIp(ip).isPresent();
    }

    @Override
    public DeleteSuspiciousIPResponse delete(String ip) {
        Optional<UserEntity> userEntity = userService.getLoggedUser();
        if (!userEntity.get().getRole().name().equals(RoleEnum.SUPPORT.name())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        validator.validateIp(ip);
        if (!ipIsBlacklisted(ip)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<SuspiciousIPEntity> byIp = suspiciousIPRepository.findByIp(ip);
        suspiciousIPRepository.delete(byIp.get());
        return new DeleteSuspiciousIPResponse("IP " + ip + " successfully removed!");
    }

    @Override
    public List<SuspiciousIPResponse> getAll() {
        return suspiciousIPRepository
                .findAll()
                .stream()
                .map((a) -> new SuspiciousIPResponse(a.getId(), a.getIp()))
                .collect(Collectors.toList());
    }
}
