package com.example;

import java.util.Collection;
import java.util.Optional;

public final class UserUpdateAction implements UserAction {

    private final UserRepository userRepository;
    private final Collection<FailureHandler> failureHandlers;
    private final String username;

    public UserUpdateAction(String username, UserRepository userRepository,
            Collection<FailureHandler> onFailure) {
        this.userRepository = userRepository;
        this.failureHandlers = onFailure;
        this.username = username;
    }

    @Override
    public Result<User> handle(UserRequest request) {
        Optional<User> byUsername = getUser();
        Result<User> result = new Result<>();

        if (byUsername.isPresent()) {
            result = request.handle(byUsername.get());
        } else {
            result.add("No such user");
            return result;
        }

        if (result.hasErrors()) {
            handleFailure(result);
        } else {
            userRepository.update(result.getResult().get());
        }
        return result;
    }

    private void handleFailure(Result<User> result) {
        for (FailureHandler failureHandler : failureHandlers) {
            failureHandler.onFailure(result);
        }
    }

    public Optional<User> getUser() {
        return userRepository.findByUsername(username);
    }

}
