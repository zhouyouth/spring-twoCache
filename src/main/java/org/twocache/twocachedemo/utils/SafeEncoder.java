//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.twocache.twocachedemo.utils;

import java.io.UnsupportedEncodingException;


public final class SafeEncoder {
    private SafeEncoder() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static byte[][] encodeMany(String... strs) {
        byte[][] many = new byte[strs.length][];

        for(int i = 0; i < strs.length; ++i) {
            many[i] = encode(strs[i]);
        }

        return many;
    }

    public static byte[] encode(String str) {
        try {
            if (str == null) {
                throw new IllegalArgumentException("value sent to redis cannot be null");
            } else {
                return str.getBytes("UTF-8");
            }
        } catch (UnsupportedEncodingException var2) {
            UnsupportedEncodingException e = var2;
            throw new RuntimeException(e);
        }
    }

    public static String encode(byte[] data) {
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            UnsupportedEncodingException e = var2;
            throw new RuntimeException(e);
        }
    }
}
