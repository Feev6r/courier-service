package dev.ferv.courier_service.domain.port;

public interface RedisStoragePort {

    void saveCode(String phoneNumber, String code, long ttlMinutes);
    String getCode(String phoneNumber);
    void deleteCode(String phoneNumber);
}
