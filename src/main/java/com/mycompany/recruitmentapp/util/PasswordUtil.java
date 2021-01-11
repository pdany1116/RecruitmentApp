package com.mycompany.recruitmentapp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lucis
 */
public class PasswordUtil {
    public static String convertToSha256(String password) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            String result = new BigInteger(1, digest).toString(16);
            return result;

        } catch (NoSuchAlgorithmException ex) {
            
        }
        return null;
    }
}
