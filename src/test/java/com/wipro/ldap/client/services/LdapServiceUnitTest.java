package com.wipro.ldap.client.services;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class LdapServiceUnitTest {

    @Test
    void java13test() {
        System.out.println("Hello world");
        String s = "testStr";

        Optional<String> str = Optional.of(s);

        var ss = "I am String";
        var iv = 5;

        var newString = ss.transform(String::toUpperCase);

        System.out.println(newString);


        var SW = switch(newString){
            case "gg" -> "HMM";
            case "gg2" -> "HMM2";
            default -> "def value";
        };

        System.out.println(SW);


        var JSON  = """
                        { "test" : 3,
                          "test2": "I am a normal JSON!"
                        }
                    """;


        System.out.println(JSON);

        var list = List.of("sdcs", "sdcs", "sdcs");


    }
}