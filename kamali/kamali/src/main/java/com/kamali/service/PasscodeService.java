package com.kamali.service;

import com.kamali.model.Available_lockers;
import com.kamali.repository.SlPasscodeasscodeRepositoryInMemory;
import com.kamali.strategies.IPasscodeGenerator;
import lombok.NonNull;

public class PasscodeService {

    private final IPasscodeGenerator PasscodeGenerator;
    private final SlPasscodeasscodeRepositoryInMemory slPasscodeasscodeRepository;

    public PasscodeService(IPasscodeGenerator PasscodeGenerator, SlPasscodeasscodeRepositoryInMemory slPasscodeasscodeRepository) {
        this.PasscodeGenerator = PasscodeGenerator;
        this.slPasscodeasscodeRepository = slPasscodeasscodeRepository;
    }

    @NonNull
    public String generatePasscode(@NonNull final Available_lockers slot) {
        final String Passcode = PasscodeGenerator.generatePasscode();
        slPasscodeasscodeRepository.addPasscode(Passcode, slot.getAvailable_lockersId());
        return Passcode;
    }

    public boolean validatePasscode(@NonNull final Available_lockers slot, @NonNull final String Passcode) {
        final String savedPasscode = slPasscodeasscodeRepository.getPasscode(slot.getAvailable_lockersId());
        return savedPasscode != null && savedPasscode.equals(Passcode);
    }
}
