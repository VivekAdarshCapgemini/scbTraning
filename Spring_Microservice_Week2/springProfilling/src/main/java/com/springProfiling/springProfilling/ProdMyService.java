package com.springProfiling.springProfilling;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdMyService implements MyService {
    @Override
    public void doSomething() {
        System.out.println("Doing something in prod environment");
    }
}