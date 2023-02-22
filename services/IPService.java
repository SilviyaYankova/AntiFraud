package antifraud.services;

import antifraud.models.responses.DeleteSuspiciousIPResponse;
import antifraud.models.responses.SuspiciousIPResponse;

import java.util.List;

public interface IPService {
    SuspiciousIPResponse addSuspiciousIP(String ip);

    boolean ipIsBlacklisted(String ip);

    DeleteSuspiciousIPResponse delete(String ip);

    List<SuspiciousIPResponse> getAll();
}
