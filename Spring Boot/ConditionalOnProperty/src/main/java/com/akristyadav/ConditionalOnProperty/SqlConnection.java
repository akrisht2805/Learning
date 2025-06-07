package com.akristyadav.ConditionalOnProperty;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "sqlconnection", value = "enabled" , havingValue = "true", matchIfMissing = false)
public class SqlConnection {

    SqlConnection(){
        System.out.println("Connected to SQL DB!!");
    }
}
