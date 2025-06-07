package com.akristyadav.ConditionalOnProperty;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "nosqlconnection", value = "enabled", havingValue = "true", matchIfMissing = false)
public class NoSqlConnection {

    NoSqlConnection(){
        System.out.println("Connected to No SQl DB!!");
    }
}
