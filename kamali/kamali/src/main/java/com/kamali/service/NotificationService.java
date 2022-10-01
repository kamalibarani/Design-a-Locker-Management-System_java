package com.kamali.service;

import com.kamali.model.LockerUser;
import com.kamali.model.Available_lockers;
import lombok.NonNull;

public class NotificationService {

    public void notifyUser(@NonNull final LockerUser user, @NonNull final String Passcode, @NonNull final Available_lockers slot) {

        System.out.println("Sending notification of Passcode: " + Passcode + " to: " + user + " for slot: " + slot);
    }
}
