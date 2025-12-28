package com.basics.ReviseSpringBasics.util;

import java.util.Base64;

public class ByteToBase64Util {
    public static String byteArrayToBase64(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }
}
