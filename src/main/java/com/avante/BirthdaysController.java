package com.avante;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.avante.db.*;
import com.avante.dto.*;

import java.util.List;

/**
 * Created by java2303 on 06.12.16.
 */

// cross origin to allow calls from another site
@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/api/birthdays")
public class BirthdaysController {

    private static Logger LOGGER = Logger.getLogger(BirthdaysController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BirthdayRepository birthdayRepository;

    @RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
    public List<Birthday> getBirthdays(@RequestParam String username) {
        LOGGER.info("Get birthdays for" + username);

        User user = userRepository.findByName(username);
        List<Birthday> birthdays = birthdayRepository.findByUserId(user.id);

        return birthdays;
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity addBirthday(@RequestParam String username, @RequestBody Birthday birthday) {
        LOGGER.info("Save birthday!" + birthday.toString());
        Birthday newBirthday = birthday;
        newBirthday.userId = userRepository.findByName(username).id;
        birthdayRepository.insert(birthday);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity deleteBirthday(@RequestBody Birthday birthday) {
        LOGGER.info("Delete birthday!" + birthday.toString());
        birthdayRepository.delete(birthday);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity updateBirthday(@RequestBody Birthday birthday) {
        LOGGER.info("Update birthday!" + birthday.toString());
        birthdayRepository.save(birthday);
        return ResponseEntity.ok().build();
    }
}

