package com.springProfiling.springProfilling;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Dev")
public class QatMyService {

    public void qatMethod(){

        System.out.println("Welcome to QAT Env");
    }
    // write method to base64 conversion of string input
    public String base64Conversion(String input){
        return java.util.Base64.getEncoder().encodeToString(input.getBytes());
    }

    

}
