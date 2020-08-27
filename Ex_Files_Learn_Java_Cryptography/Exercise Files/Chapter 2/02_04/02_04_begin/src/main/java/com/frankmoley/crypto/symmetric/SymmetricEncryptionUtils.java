package com.frankmoley.crypto.symmetric;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class SymmetricEncryptionUtils {

    private static final String AES = "AES";

    public static SecretKey createAESKey() throws Exception{
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(256, secureRandom);
        return keyGenerator.generateKey();
    }
}
