package com.muhardin.endy.belajar.iso8583;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class IsoHelperTests {

    @Test
    public void testHitungBitmap(){
        Map<Integer, String> message = new HashMap<>();

        message.put(7, "0806153031");
        message.put(11, "120031");
        message.put(70, "301");

        BigInteger bitmap = IsoHelper.hitungBitmap(message);
        Assert.assertNotNull(bitmap);
        System.out.println("Bitmap : "+bitmap.toString(16));

        String strMessage = bitmap.toString(16) + "0806153031" + "120031" + "301";

        System.out.println("Message : "+strMessage);
    }
}