package com.kamali.strategies;

import com.kamali.model.LockerItem;
import com.kamali.model.Available_lockers;
import lombok.NonNull;

import java.util.List;

public interface IAvailable_lockersFilteringStrategy {

    @NonNull
    List<Available_lockers> filterAvailable_lockerss(@NonNull List<Available_lockers> slots, @NonNull LockerItem lockerItem);
}
