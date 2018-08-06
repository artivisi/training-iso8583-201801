package com.muhardin.endy.belajar.iso8583;

import java.math.BigInteger;
import java.util.Map;

public abstract class IsoHelper {
    public static String isomsgToString(String mti, Map<Integer, String> isomsg){
        StringBuilder hasil = new StringBuilder();
        hasil.append(mti);
        hasil.append(hitungBitmap(isomsg).toString(16).toUpperCase());
        isomsg.keySet().stream()
        .sorted()
        .forEach(x -> hasil.append(isomsg.get(x)));
        return hasil.toString();
    }

    public static BigInteger hitungBitmap(Map<Integer, String> isomsg){
        BigInteger hasil = BigInteger.ZERO;

        int maxBit = 128;

        for(int i=0; i<maxBit; i++){
            if(i > 64){
                hasil = hasil.setBit(maxBit - 1);
            }
            if(isomsg.get(i) != null) {
                hasil = hasil.setBit(maxBit - i);
            }
        }

        return hasil;
    }
}