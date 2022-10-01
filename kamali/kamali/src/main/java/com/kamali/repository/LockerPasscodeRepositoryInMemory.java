package com.kamali.repository;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Available_lockersPasscodeRepositoryInMemory implements IAvailable_lockersPasscodeRepository {

    private final Map<String, String> lockerIdToPasscodeMap;

    public Available_lockersPasscodeRepositoryInMemory() {
        this.lockerIdToPasscodeMap = new HashMap<>();
    }

    @Override
    public void addPasscode(@NonNull final String Passcode, @NonNull final String lockerId) {
        lockerIdToPasscodeMap.put(lockerId, Passcode);
    }

    @Override
    public String getPasscode(@NonNull final String lockerid) {
        return lockerIdToPasscodeMap.get(LockerId);
    }
}
