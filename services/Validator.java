package antifraud.services;

public interface Validator {
    void validateIp(String ip);

    void validateCardNumber(String cardNumber);
}
