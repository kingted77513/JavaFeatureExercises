package jdk8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Base64CallTest {

    private static String decodeStr = "runoob?java8";
    private static String encodeStr = "cnVub29iP2phdmE4";
    private static String encodeUrlStr = "cnVub29iP2phdmE4";
    private static String encodeMimeStr = "";

    @Test
    void encodeToString_GiveDecodeString_ReturnEncodeString() {

        String excepted = encodeStr;
        String actual = Base64.getEncoder().encodeToString(decodeStr.getBytes(StandardCharsets.UTF_8));

        Assertions.assertEquals(excepted, actual);

    }

    @Test
    void decode_GiveEncodeString_ReturnDecodeString() {

        String excepted = decodeStr;
        String actual = new String(Base64.getDecoder().decode(encodeStr), StandardCharsets.UTF_8);

        Assertions.assertEquals(excepted, actual);

    }
}
