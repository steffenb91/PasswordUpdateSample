package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordUpdateRestController {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public PasswordUpdateRestController(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @PostMapping("/updatepassword")
    public Result<User> updatePassword(String username, String verificationPassword, String newPassword) {
        UserAction userUpdateAction = new UserUpdateAction(username, userRepository, getFailureHandlers());
        PasswordVerification simplePasswordVerification = new SimplePasswordVerification(
                userUpdateAction.getUser().get(), newPassword);
        UserRequest updatePasswordRequest = new PasswordUpdateRequest(simplePasswordVerification, newPassword);
        return userUpdateAction.handle(updatePasswordRequest);
    }

    private Collection<FailureHandler> getFailureHandlers() {
        Collection<FailureHandler> failureHandlers = new ArrayList<>();
        Collections.addAll(failureHandlers, new OutputFailureHandler(),
                new EmailFailureHandler(emailService));
        return failureHandlers;
    }

}
