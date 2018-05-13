package com.xupt.Tool;

import com.alibaba.fastjson.JSON;
import com.xupt.dto.Payload;

import static com.xupt.Tool.HMACSHA256Util.HMACSHA256;

public class TokenUtil {

    private final static String header = "{\n" +
            "\"alg\": \"HS256\",\n" +
            "\"typ\": \"JWT\"\n" +
            "}";

    public static String getHeader() {
        return header;
    }

    public static String tokenCreat(){
        String token = null;
        String headerStr = TokenUtil.getHeader();
        Payload payload = new Payload();
        payload.setIss("zwq");
        payload.setIat("time");
        payload.setAud("dlg");
        payload.setExp("timed");
        payload.setSub("all");
        String payloadStr = JSON.toJSONString(payload);
        String signatureStr = HMACSHA256(headerStr+payloadStr,String.valueOf(System.currentTimeMillis()));
        token= Base64Util.encoder(headerStr+String.valueOf(System.currentTimeMillis()));
        //token= Base64Util.encoder(headerStr)+"."+Base64Util.encoder(payloadStr)+"."+Base64Util.encoder(signatureStr);
        return token;
    }
}
