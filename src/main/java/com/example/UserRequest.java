package com.example;

/**
 * Request to alter a user.
 */
public interface UserRequest {

    /**
     * Handles the request for the given user. No side-effects, the result is
     * returned in a dedicated {@link Result} object.
     * 
     * @param user
     * @return {@link Result} object contaning the updated user or encountered
     *         errors
     */
    Result<User> handle(User user);
}
