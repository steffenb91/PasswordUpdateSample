package com.example;

public class SimplePasswordVerification implements PasswordVerification {

    private final User user;
    private final String verificationPassword;

    public SimplePasswordVerification(User user, String verificationPassword) {
        this.user = user;
        this.verificationPassword = verificationPassword;
    }

    @Override
    public Result<User> verify() {
        PasswordVerificationStep matchOldPassword = new MatchesOldPasswordVerification(user, verificationPassword);
        Result<User> result = new Result<>();
        if (!matchOldPassword.verify()) 
            result.add("Given password does not match user password!");

        return result;
    }

}
