package com.example.uad;

import org.apache.commons.codec.digest.*;
import org.junit.jupiter.api.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.*;
import java.time.*;
import java.time.format.*;

public class HmacTest {

    public static final String ALGORITHM = "HmacSHA256";

    public static String calculateHMac(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance(ALGORITHM);

        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        sha256_HMAC.init(secret_key);

        return byteArrayToHex(sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    @Test
    public void Test() throws Exception {
        // see https://en.wikipedia.org/wiki/HMAC#Examples
        // expected output:
        // HMAC_SHA256("key", "The quick brown fox jumps over the lazy dog") = f7bc83f430538424b13298e6aa6fb143ef4d59a14946175997479dbc2d1a3cd8
        System.out.println(calculateHMac("key", "The quick brown fox jumps over the lazy dog"));
        System.out.println(DigestUtils.sha256Hex("abcd"));
    }


//    private String getCanonicalRequest(String method, String uuid, String date, String dateTime){
//        var result = method + "\n" +
//                "/" + bucketName + "/" + uuid + "\n" +
//                "X-Amz-Algorithm=AWS4-HMAC-SHA256" +
//                "&X-Amz-Credential=" + accessKey
//                + "%2F" + date
//                + "%2F" + "ru-central1"
//                + "%2Fs3"
//                + "%2Faws4_request"
//                + "&X-Amz-Date=" + dateTime
//                + "&X-Amz-Expires=3600"
//                + "&X-Amz-SignedHeaders=host" + "\n"
//                + "host:storage.yandexcloud.net" + "\n"
//                + "\n"
//                + "host" + "\n"
//                + "UNSIGNED-PAYLOAD";
//        System.out.println("getCanonicalRequest: " + result);
//        return result;
//    }
}