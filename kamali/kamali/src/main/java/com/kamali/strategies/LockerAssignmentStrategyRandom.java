package com.kamali.strategies;

import com.kamali.model.Available_lockers;
import lombok.NonNull;

import java.util.List;

public class Available_lockersAssignmentStrategyRandom implements IAvailable_lockersAssignmentStrategy {

    private final IRandomGenerator randomGenerator;

    public Available_lockersAssignmentStrategyRandom(@NonNull final IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Available_lockers pickAvailable_lockers(@NonNull final List<Available_lockers> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}
