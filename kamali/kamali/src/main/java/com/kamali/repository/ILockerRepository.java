package com.kamali.repository;

import com.kamali.model.Locker;
import com.kamali.model.Available_lockers;
import lombok.NonNull;

import java.util.List;

public interface ILockerRepository {

    @NonNull
    Locker createLocker(@NonNull String id);

    @NonNull
    List<Slot> getAllAvailableLockers();
}
