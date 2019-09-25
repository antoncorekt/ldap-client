package com.wipro.ldap.client.services;

import com.wipro.ldap.client.configuration.LdapConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Anton Kozlovskyi
 * @date 25 Sep 2019
 */
@Log4j2
@Component
public class LdapService {

    private final LdapConfig ldapConfig;

    public LdapService(LdapConfig ldapConfig) {
        this.ldapConfig = ldapConfig;
    }

    public List<String> getLdapUserGroups(final String user, final String password) throws NamingException {
        final InitialDirContext context = connectToLdap(user, password);

        final NamingEnumeration<SearchResult> namingEnumeration = context.search(ldapConfig.getDn(),"(cn=" + user+")",new SearchControls());

        return enumerationAsStream(namingEnumeration)
                .map(SearchResult::getAttributes)
                .map(attributes -> attributes.get("memberof"))
                .map(Object::toString)
                .flatMap(strAttr -> strAttr.transform(str -> Stream.of(str.split(","))))
                .filter(x -> x.contains("CN"))
                .map(x -> x.replaceAll(".*=", ""))
                .collect(Collectors.toList());
    }

    private InitialDirContext connectToLdap(final String user, final String password) throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://" + ldapConfig.getServer() + ":" + ldapConfig.getPort());
        props.put(Context.SECURITY_PRINCIPAL, "CN=" + user + "," + ldapConfig.getDn());
        props.put(Context.SECURITY_CREDENTIALS, password);//dn user password

        return new InitialDirContext(props);
    }

    public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        new Iterator<T>() {
                            public T next() {
                                return e.nextElement();
                            }
                            public boolean hasNext() {
                                return e.hasMoreElements();
                            }
                        },
                        Spliterator.ORDERED), false);
    }

}
