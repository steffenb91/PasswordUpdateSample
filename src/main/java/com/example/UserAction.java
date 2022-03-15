package com.example;

import java.util.Optional;

public interface UserAction {
    /**
     * Invokes a request. 
     * 
     * @param request to invoke
     * @return response indicating if the action failed or succeeded
     */
    Result<User> handle(UserRequest request);

    Optional<User> getUser();
}
