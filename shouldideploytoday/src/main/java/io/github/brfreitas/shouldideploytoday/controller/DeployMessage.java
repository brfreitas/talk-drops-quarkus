package io.github.brfreitas.shouldideploytoday.controller;

import io.github.brfreitas.shouldideploytoday.model.Reason;
import io.github.brfreitas.shouldideploytoday.service.ReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@Api(value = "Deploy Message")
public class DeployMessage {

    private final ReasonService service;

    @Autowired
    public DeployMessage(ReasonService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get a random deploy message")
    @GetMapping(produces = "text/plain")
    public ResponseEntity message(){
        return  service.findRandom()
                .map(r -> ResponseEntity.ok(r.getMessage()))
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Add a new deploy message")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity newMessage(@RequestBody Reason reason){
        return ResponseEntity.ok(service.create(reason));
    }
}
