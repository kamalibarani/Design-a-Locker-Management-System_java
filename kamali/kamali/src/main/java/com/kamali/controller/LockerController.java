package com.kamali.controller;

import com.kamali.model.Locker;
import com.kamali.model.Size;
import com.kamali.model.Available_Lockers;
import com.kamal.service.LockerService;
import com.kamal.service.passcodeService;
import lombok.NonNull;

import java.util.List;

public class LockerController {

    private final LockerService lockerService;
    private final PasscodeService PasscodeService;

    public LockerController(@NonNull final LockerService lockerService,
                            @NonNull final PasscodeService PasscodeService) {
        this.lockerService = lockerService;
        this.PasscodeService = PasscodeService;
    }

    public Locker createLocker(@NonNull final String passcode) {
        return lockerService.createLocker(passcode);
    }

    public Available_Lockers createAvailable_Lockers(@NonNull final Locker locker, @NonNull final Size av_lockersSize) {
        return lockerService.createAvailable_Lockers(locker, av_lockersSize);
    }

    public List<Available_Lockers> getAvailable_Lockers() {
        return lockerService.getAllAvailable_Lockers();
    }

    public boolean unlockAvailable_Lockers(@NonNull final Available_Lockers av_lockers, @NonNull final String Passcode) {
        return PasscodeService.validatePasscode(av_lockers, Passcode);
      
    }

    public void deallocateAvailable_Lockers(@NonNull final Available_Lockers av_lockers) {
        lockerService.deallocateAvailable_Lockers(av_lockers);
    }
}
