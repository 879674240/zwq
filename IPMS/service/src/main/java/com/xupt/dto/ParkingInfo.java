package com.xupt.dto;

public class ParkingInfo {

    /**
     * 卡号
     */
    private String cardno;
    /**
     * 车牌号
     */
    private String carnum;
    /**
     * 车类型
     */
    private String type;
    /**
     * 收费类型
     */
    private String types;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
