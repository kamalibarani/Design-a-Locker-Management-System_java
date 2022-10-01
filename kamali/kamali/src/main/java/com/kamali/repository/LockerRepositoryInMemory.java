package com.kamali.repository;

import com.kamali.exceptions.LockerAlreadyExistsException;
import com.kamali.model.Locker;
import com.kamali.model.Available_lockers;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class LockerRepositoryInMemory implements ILockerRepository {
    private final List<Locker> allLockers;

    public LockerRepositoryInMemory() {
        this.allLockers = new ArrayList<>();
    }

    public Locker getLocker(@NonNull final String id) {
        for (Locker locker : this.allLockers) {
            if (locker.getId().equals(id)) {
                return locker;
            }
        }
        return null;
    }

    @NonNull
    public Locker createLocker(@NonNull final String id) {
        if (getLocker(id) != null) {
            throw new LockerAlreadyExistsException();
        }
        final Locker newLocker = new Locker(id);
        allLockers.add(newLocker);
        return newLocker;
    }

    @NonNull
    public List<Available_lockers> getAllAvailableAvailable_lockerss() {
        final List<Available_lockers> result = new ArrayList<>();
        for (Locker locker : allLockers) {
            result.addAll(locker.getAvailable_lockers());
        }
        return result;
    }

}
