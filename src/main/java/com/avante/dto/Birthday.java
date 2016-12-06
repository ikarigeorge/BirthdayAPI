package com.avante.dto;

/**
 * Created by java2303 on 06.12.16.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import java.util.Date;

public class Birthday {
    @Id
    public String id;

    public String name;


    public Date birthday;
    public Boolean age;
    public String userId;

    public Birthday(){

    }

    public Birthday(String name, Date birthday, Boolean age, String userId){
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.userId = userId;

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
