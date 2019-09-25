package com.wipro.ldap.client.controllers;

import com.wipro.ldap.client.services.LdapService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.naming.NamingException;

/**
 * @author Anton Kozlovskyi
 * @date 25 Sep 2019
 */

@RestController
@Log4j2
public class LdapController {

    @Autowired
    private LdapService ldapService;

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/api/ldap/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<?> ldapLogin(@RequestParam("login") String login, @RequestParam("password") String password) throws NamingException {
        log.info("ldapLogin: {}", login);

        return Flux.fromIterable(ldapService.getLdapUserGroups(login,password));
    }

    @GetMapping("/hello")
    public String getHelloWord(){
        return "Hello world";
    }

}
