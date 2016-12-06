package com.avante.db;

import com.avante.dto.Birthday;
import com.avante.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by java2303 on 06.12.16.
 */
public interface BirthdayRepository extends MongoRepository<Birthday, String> {

    public Birthday findByName(String Name);
    public List<Birthday> findByUserId(String UserId);

}
