package nl.hlopez.methodsecurityissue.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MyControllerApi {

    @PostMapping(path = "/v1/message", consumes = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<Void> postAMessage(@RequestBody String message);

}
