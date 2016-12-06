package com.avante.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

/**
 * Created by java2303 on 06.12.16.
 */
public class User {
    @Id
    public String id;

    public String name;
    public String password;

    public User(){

    }

    public User(String name, String password){
        this.name = name;
        this.password = password;

    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException pE) {
            pE.printStackTrace();
        }
        return super.toString();
    }
}
