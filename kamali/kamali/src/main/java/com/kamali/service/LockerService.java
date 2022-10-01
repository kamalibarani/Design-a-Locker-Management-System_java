package com.kamali.service;

import com.kamali.exceptions.NoAvailable_lockersAvailableException;
import com.kamali.model.Locker;
import com.kamali.model.LockerItem;
import com.kamali.model.Size;
import com.kamali.model.Available_lockers;
import com.kamali.repository.ILockerRepository;
import com.kamali.strategies.IAvailable_lockersAssignmentStrategy;
import com.kamali.strategies.IAvailable_lockersFilteringStrategy;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public class LockerService {

    private final IAvailable_lockersAssignmentStrategy assignmentStrategy;
    private final ILockerRepository lockerRepository;
    private final IAvailable_lockersFilteringStrategy lockerFilteringStrategy;

    public LockerService(@NonNull final IAvailable_lockersAssignmentStrategy assignmentStrategy,
                         @NonNull final ILockerRepository lockerRepository,
                         @NonNull final IAvailable_lockersFilteringStrategy lockerFilteringStrategy) {
        this.assignmentStrategy = assignmentStrategy;
        this.lockerRepository = lockerRepository;
        this.lockerFilteringStrategy = lockerFilteringStrategy;
    }

    @NonNull
    public Locker createLocker(@NonNull final String lockerId) {
        return lockerRepository.createLocker(lockerId);
    }

    @NonNull
    public Available_lockers createAvailable_lockers(@NonNull final Locker locker, @NonNull final Size lockerSize) {
        final Available_lockers locker = new Available_lockers(UUID.randomUUID().toString(), lockerSize, locker);
        locker.addAvailable_lockers(locker);
        return locker;
    }

    @NonNull
    public List<Available_lockers> getAllAvailableAvailable_lockerss() {
        return lockerRepository.getAllAvailableAvailable_lockerss();
    }

    @NonNull
    public Available_lockers allocateAvailable_lockers(@NonNull final LockerItem lockerItem) {

        final List<Available_lockers> allAvailableAvailable_lockerss = lockerRepository.getAllAvailableAvailable_lockerss();
        final List<Available_lockers> filteredAvailable_lockerss = lockerFilteringStrategy.filterAvailable_lockerss(allAvailableAvailable_lockerss, lockerItem);
        final Available_lockers lockerToBeAllocated = assignmentStrategy.pickAvailable_lockers(filteredAvailable_lockerss);

        if (lockerToBeAllocated == null) {
            throw new NoAvailable_lockersAvailableException();
        }

        lockerToBeAllocated.allocateBook(lockerItem);
        return lockerToBeAllocated;
    }

    public void deallocateAvailable_lockers(@NonNull final Available_lockers locker) {
        locker.deallocateAvailable_lockers();
    }
}
