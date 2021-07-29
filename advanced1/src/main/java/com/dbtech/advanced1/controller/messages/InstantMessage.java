package com.dbtech.advanced1.controller.messages;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class InstantMessage implements MessagingService {
    @Override
    public String getMessage() {
        return "Hello from InstantMessage!";
    }
}
