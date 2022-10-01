package com.kamali.repository;

import lombok.NonNull;

public interface ILokerPasscodeRepository {
    void addPasscode(@NonNull String Passcode, @NonNull String slotId);

    String getPasscode(@NonNull String slotId);
}
