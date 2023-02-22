package antifraud.controllers;

import antifraud.models.requests.SuspiciousIPRequest;
import antifraud.models.responses.DeleteSuspiciousIPResponse;
import antifraud.models.responses.SuspiciousIPResponse;
import antifraud.services.IPService;
import antifraud.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/api/antifraud")
@RequiredArgsConstructor
@RestController
public class SuspiciousController {
    final IPService IPService;
    final UserService userService;

    @PostMapping("/suspicious-ip")
    SuspiciousIPResponse addSuspiciousIPs(@RequestBody @Valid SuspiciousIPRequest request) {
        return IPService.addSuspiciousIP(request.getIp());
    }

    @DeleteMapping("suspicious-ip/{ip}")
    DeleteSuspiciousIPResponse delete(@PathVariable String ip) {
        return IPService.delete(ip);
    }

    @GetMapping("/suspicious-ip")
    List<SuspiciousIPResponse> get() {
        return IPService.getAll();
    }
}
