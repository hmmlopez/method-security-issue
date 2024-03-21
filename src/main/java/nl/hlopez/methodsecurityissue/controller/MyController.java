package nl.hlopez.methodsecurityissue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController { // implements MyControllerApi {

    private final Logger logger = LoggerFactory.getLogger(MyController.class);

    @PreAuthorize("hasRole('SUPERPOWER')")
    @PostMapping(path = "/v1/message", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Void> postAMessage(@RequestBody String message){
        logger.info("Received message: {}", message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PreAuthorize("hasRole('SUPERPOWER')")
//    @Override
//    public ResponseEntity<Void> postAMessage(String message){
//        logger.info("Received message: {}", message);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

}
