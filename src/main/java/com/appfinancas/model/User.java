package com.appfinancas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

    private String name;
    private String password;
}
