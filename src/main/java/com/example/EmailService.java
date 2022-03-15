package com.example;

import java.util.Collection;

public interface EmailService {

    void sendAll(Collection<String> errorMessages);

}
