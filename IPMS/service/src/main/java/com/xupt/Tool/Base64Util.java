package com.xupt.Tool;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Util {

    /**
     * 编码
     * @param str
     * @return
     */
    public static String encoder(String str){
        final BASE64Encoder encoder = new BASE64Encoder();
        final byte[] textByte;
        String encodedText = "";
        try {
            textByte = str.getBytes("UTF-8");
            encodedText = encoder.encode(textByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedText;
    }

    /**
     * 解码
     * @param str
     * @return
     */
    public static String decoder (String str){
        final BASE64Decoder decoder = new BASE64Decoder();
        String string = "";
        try {
            string = new String(decoder.decodeBuffer(str), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
