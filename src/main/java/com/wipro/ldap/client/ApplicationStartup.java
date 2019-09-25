package com.wipro.ldap.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Anton Kozlovskyi
 * @date 25 Sep 2019
 */
@SpringBootApplication
public class ApplicationStartup {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartup.class, args);
    }

//    enum TestEnum {
//        A,
//        B,
//        NON
//    }
//    public static void main(String[] args) {
//
//        System.out.println("Hello world");
//
//        String s = "testStr";
//
//        Optional<String> str = Optional.of(s);
//
//        var ss = "I am String";
//
//        var iv = 5;
//
//        var newString = ss.transform((a)->a.toUpperCase());
//
//        System.out.println(newString);
//
//
//        TestEnum testEnum = TestEnum.A;
//
//
//        var SW = switch(testEnum){
//            case A -> "HMM";
//            default -> "smaller than one or more than three";
//        };
//
//        System.out.println(SW);
//
//
//        var JSON  = """
//                        { "test" : 3,
//                          "test2": "I am a normal JSON!"
//                        }
//                    """;
//
//
//        System.out.println(JSON);
//
//        List.of("sdcs","sdcs","sdcs");
//
//    }

}
