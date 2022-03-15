package com.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Result<T> {

    private Optional<T> resultObject;
    private Set<String> errorMessages;

    public Result(){
        this.errorMessages = new HashSet<>();
        resultObject = Optional.empty();
    }

    public Result(T resultObject){
        this();
        this.resultObject = Optional.of(resultObject);
    }

    public void add(String error){
        errorMessages.add(error);
    }

    public Set<String> getErrorMessages(){
        return this.errorMessages;
    }

    public boolean hasErrors(){
        return !errorMessages.isEmpty();
    }

    public Optional<T> getResult(){
        return resultObject;
    }
}
