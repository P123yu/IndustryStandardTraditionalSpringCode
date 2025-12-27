package com.basics.ReviseSpringBasics.util;

import java.util.Base64;

public class ByteToBase64Util {
    public static String byteArrayToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
