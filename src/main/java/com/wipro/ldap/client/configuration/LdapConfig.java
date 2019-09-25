package com.wipro.ldap.client.configuration;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * @author Anton Kozlovskyi
 * @date 25 Sep 2019
 */
//@Configuration
@ConfigurationProperties(prefix = "ldap")
@Data
@Log4j2
public class LdapConfig {

    private String server;
    private String port;
    private String dn;

    @PostConstruct
    public void init(){
        log.info("init PostConstruct");
        log.info("ldapServer: {}", server);
        log.info("ldapPort: {}", port);
        log.info("baseDn: {}", dn);
    }

}
