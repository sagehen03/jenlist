package org.drewandjen.web;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

/**
 * Created by dhite on 3/19/16.
 */
public class BcryptTest {

    @Test
    public void verifyPass(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertTrue(encoder.matches("password", "$2a$10$tEelzEleqaGTC31hNZFKbeJu/SJIqBLzoO0NyWhmVce7lqLrNFQTe"));
    }
}
