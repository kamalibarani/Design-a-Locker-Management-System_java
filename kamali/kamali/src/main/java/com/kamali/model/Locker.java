package com.kamali.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locker {

    private final String id;
    private final List<Available_Lockers> av_lokers;

    public Locker(String id) {
        this.id = id;
        this.av_lockers = new ArrayList<>();
    }

    public void addlockers(@NonNull final Available_lockers newAvailable_lockers) {
        this.av_lokers.add(newAvailable_Lockers);
    }

    @NonNull
    public List<Available_Lockers> getAvailableLockers() {
        final List<Available_Lockers> result = new ArrayList<>();
        for (Available_Lockers av_lokers : this.av_lokers) {
            if (av_lokers.isAvailable()) {
                result.add(av_lokers);
            }
        }
        return result;
    }
}
