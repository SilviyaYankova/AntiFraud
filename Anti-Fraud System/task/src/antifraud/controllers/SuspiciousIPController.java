package antifraud.controllers;

import antifraud.models.requests.SuspiciousIPRequest;
import antifraud.models.responses.DeleteSuspiciousIPResponse;
import antifraud.models.responses.SuspiciousIPResponse;
import antifraud.services.SuspiciousIPService;
import antifraud.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("hasRole('SUPPORT')")
@RequestMapping("/api/antifraud/suspicious-ip")
@RequiredArgsConstructor
@RestController
public class SuspiciousIPController {
    final SuspiciousIPService SuspiciousIPService;
    final UserService userService;

    @PostMapping()
    SuspiciousIPResponse addSuspiciousIPs(@RequestBody @Valid SuspiciousIPRequest request) {
        return SuspiciousIPService.addSuspiciousIP(request.getIp());
    }

    @DeleteMapping("/{ip}")
    DeleteSuspiciousIPResponse delete(@PathVariable String ip) {
        return SuspiciousIPService.delete(ip);
    }

    @GetMapping()
    List<SuspiciousIPResponse> get() {
        return SuspiciousIPService.getAll();
    }
}
