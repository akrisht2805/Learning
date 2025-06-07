package com.akristyadav.ConditionalOnProperty;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DbConnection {

    @Autowired(required = false)
    private SqlConnection sqlConnection;

    @Autowired(required = false)
    private NoSqlConnection noSqlConnection;

    @PostConstruct
    public void init(){
        System.out.println("DB connection stable with below db");
        System.out.println("is My Sql Connection Object is NULL : "+ Objects.isNull(sqlConnection));
        System.out.println("is My NoSql Connection Object is NULL : "+ Objects.isNull(noSqlConnection));
    }

}
