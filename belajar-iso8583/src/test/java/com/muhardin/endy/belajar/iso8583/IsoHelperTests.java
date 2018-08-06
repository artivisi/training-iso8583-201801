package com.muhardin.endy.belajar.iso8583;

import java.math.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.junit.Assert;
import org.junit.Test;

public class IsoHelperTests {

    @Test
    public void testEchoRequest(){
        Map<Integer, String> message = new HashMap<>();

        message.put(7, "0806153031");
        message.put(11, "120031");
        message.put(70, "301");

        BigInteger bitmap = IsoHelper.hitungBitmap(message);
        Assert.assertNotNull(bitmap);
        System.out.println("Bitmap : "+bitmap.toString(16));

        System.out.println("Message : "+IsoHelper.isomsgToString("0800", message));
    }

    @Test
    public void testEchoResponse(){
        Map<Integer, String> message = new HashMap<>();

        message.put(7, "0806153031");
        message.put(11, "120031");
        message.put(39, "00");
        message.put(70, "301");

        BigInteger bitmap = IsoHelper.hitungBitmap(message);
        Assert.assertNotNull(bitmap);
        System.out.println("Bitmap : "+bitmap.toString(16));

        System.out.println("Message : "+IsoHelper.isomsgToString("0810", message));
    }

    @Test
    public void testBalanceInquiryResponse(){
        Map<Integer, String> message = new HashMap<>();

        message.put(3, "311000");
        message.put(4, StringUtils.leftPad(new BigDecimal(125000).setScale(0, RoundingMode.HALF_EVEN).toString(), 19, "0"));
        message.put(7, "0806153031");
        message.put(11, "120031");
        message.put(39, "00");
        message.put(48, "013ENDY MUHARDIN");
        message.put(102, "987654321");

        System.out.println("Message : "+IsoHelper.isomsgToString("0110", message));
    }
}