package com.example;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

    void update(User user);

}
