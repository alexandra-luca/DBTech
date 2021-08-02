package com.dbtech.advanced1.controller.messages;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class SMS implements MessagingService {
    @Override
    public String getMessage() {
        return "Hello from SMS!";
    }
}
