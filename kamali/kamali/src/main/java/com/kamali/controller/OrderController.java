package com..controller;

import com.kamali.model.Buyer;
import com.kamali.model.LockerItem;
import com.kamali.model.Available_lockers;
import com.kamali.service.LockerService;
import com.kamali.service.NotificationService;
import com.kamali.service.PasscodeService;
import lombok.NonNull;

public class OrderController {
    private final PasscodeService PasscodeService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public OrderController(@NonNull final NotificationService notificationService,
                           @NonNull final PasscodeService PasscodeService,
                           @NonNull final LockerService lockerService) {
        this.lockerService = lockerService;
        this.PasscodeService = PasscodeService;
        this.notificationService = notificationService;
    }

    public Available_lockers allocateLocker(@NonNull final Buyer buyer, @NonNull final LockerItem lockerItem) {
        final Available_lockers slot = lockerService.allocateAvailable_lockers(lockerItem);
        final String Passcode = PasscodeService.generatePasscode(slot);
        notificationService.notifyUser(buyer, Passcode, slot);
        return slot;
    }
}
