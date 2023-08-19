package com.DocDB.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class PingController {

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Integer getApiVersion() {
        return 1;
    }

}
