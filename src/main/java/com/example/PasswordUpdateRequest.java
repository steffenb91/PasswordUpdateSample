package com.example;

public class PasswordUpdateRequest implements UserRequest {

    private final PasswordVerification passwordVerification;
    private final String newPassword;

    /**
     * Request to update the password.
     * 
     * @param passwordVerification {@link PasswordVerificationStep} to use
     * @param username             Username of the user the password update should
     *                             be done for
     * @param newPassword          the new password
     */
    public PasswordUpdateRequest(PasswordVerification passwordVerification, String newPassword) {
        this.passwordVerification = passwordVerification;
        this.newPassword = newPassword;
    }

    /**
     * Updates the user´s password.
     * 
     * @param user User to update the password from
     * 
     * @return {@link Result} object containing the updated user or a set of
     *         encountered errors
     */
    @Override
    public Result<User> handle(User user) {
        Result<User> result = passwordVerification.verify();
        if (!result.hasErrors()) {
            result = updatePassword(user, newPassword);
        }
        return result;
    }

    private Result<User> updatePassword(User user, String newPassword2) {
        User updatedUser = new User(user.getUsername(), newPassword2);
        return new Result<>(updatedUser);
    }
}
