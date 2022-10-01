package com.kamali.model;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Book implements LockerItem {
    private final String username;
    private final String passcode;

    public Book(@NonNull final String username, @NonNull final String passcode) {
        this.username = username;
        this.passcode = passcode;
    }
}
