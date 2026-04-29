package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.mongo.LogEntry;
import com.example.demo.repository.mongo.LogRepository;
import com.example.demo.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogRepository logRepository;

    /*public TestController(UserRepository userRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }*/

    @GetMapping("/v1/getDeatils")
    public String getDetails(){
        String s = "These are the details;";

        return s;
    }



   @PostMapping("/v1/test")
    public String test() {
        User user = new User();
        user.setName("Swati");
        userRepository.save(user);

        LogEntry log = new LogEntry();
        log.setMessage("Saved user");
        logRepository.save(log);

        return "Saved in both DBs!";
    }
}
