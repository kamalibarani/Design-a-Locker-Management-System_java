package com.kamali.strategies;

import lombok.NonNull;

public class PasscodeGeneratorRandom implements IPasscodeGenerator {
    private final int PasscodeLength;
    private final IRandomGenerator randomGenerator;

    public PasscodeGeneratorRandom(@NonNull final Integer PasscodeLength, @NonNull final IRandomGenerator randomGenerator) {
        this.PasscodeLength = PasscodeLength;
        this.randomGenerator = randomGenerator;
    }

    @NonNull
    @Override
    public String generatePasscode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < PasscodeLength; i++) {
            stringBuilder.append(randomGenerator.getRandomNumber(10));
        }
        return stringBuilder.toString();
    }
}
