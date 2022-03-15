package com.example;

public class EmailFailureHandler implements FailureHandler {

    private final EmailService emailService;

    public EmailFailureHandler(EmailService emailService){
        this.emailService = emailService;
    }

    @Override
    public void onFailure(Result<?> result) {
        emailService.sendAll(result.getErrorMessages());
    }
    
}
