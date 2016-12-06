package com.avante.db;

import com.avante.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

        public User findByName(String Name);

}
