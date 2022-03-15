package com.example;

public class MatchesOldPasswordVerification implements PasswordVerificationStep {

    private final String verificationPassword;
    private final User user;

    public MatchesOldPasswordVerification(User user, String verificationPassword) {
        this.verificationPassword = verificationPassword;
        this.user = user;
    }

    @Override
    public boolean verify() {
        return user.isCorrectPassword(verificationPassword);
    }

}
