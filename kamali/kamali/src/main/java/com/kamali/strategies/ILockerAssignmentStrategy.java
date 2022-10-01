package com.kamali.strategies;

import com.kamali.model.Size;
import com.kamali.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotAssignmentStrategy {

    Slot pickSlot(@NonNull List<Slot> slots);
}
