package com.kamali.model;

import com.kamali.exceptions.BadRequestException;
import com.kamali.exceptions.LockerAlreadyOccupiedException;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

@Getter
public class Available_Lockers {

    private final String passcode ;
     private final String username;
    private final Size size;
    private final Locker locker;
    private LockerItem currentLockerItem;
    

    public Available_Lockers(@NonNull final String passcode,@NonNull final String username, @NonNull final Size size, @NonNull final Locker locker) {
        this.passcode = passcode;
        this.username = username;
        this.size = size;
        this.locker = locker;
        this.currentLockerItem = null;
    }

    synchronized public void allocateLocker(@NonNull final LockerItem newLockerItem) {
        if (this.currentLockerItem != null) {
            throw new LockerAlreadyOccupiedException();
        }
        this.allocationDate = new Date();
        this.currentLockerItem = newLockerItem;
    }

    synchronized public void deallocateLocker() {
        this.currentLockerItem = null;
    }

    synchronized public boolean isAvailable() {
        return this.currentLockerItem == null;
    }
}
