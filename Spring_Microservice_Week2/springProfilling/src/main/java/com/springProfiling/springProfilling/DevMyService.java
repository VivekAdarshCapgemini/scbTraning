package com.springProfiling.springProfilling;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevMyService implements MyService {
    @Override
    public void doSomething() {
        System.out.println("Doing something in dev environment");
    }
}
