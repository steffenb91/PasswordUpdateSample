package com.example;

public class OutputFailureHandler implements FailureHandler {

    @Override
    public void onFailure(Result<?> result) {
        for (String errorMessage : result.getErrorMessages()) {
            System.err.println(errorMessage);
        }
    }
    
}
