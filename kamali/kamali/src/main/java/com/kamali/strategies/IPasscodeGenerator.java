package com.kamali.strategies;

import lombok.NonNull;

public interface IPasscodeGenerator {

    @NonNull
    String generatePasscode();
}
