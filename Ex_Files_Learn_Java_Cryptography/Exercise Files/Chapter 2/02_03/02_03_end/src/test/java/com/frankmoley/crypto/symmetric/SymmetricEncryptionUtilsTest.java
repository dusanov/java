package com.frankmoley.crypto.symmetric;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricEncryptionUtilsTest {

    @Test
    void createAESKey() throws Exception {
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        assertNotNull(key);
        System.out.println(DatatypeConverter.printHexBinary(key.getEncoded()));
    }
}