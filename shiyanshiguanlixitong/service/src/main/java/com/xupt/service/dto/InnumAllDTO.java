package com.xupt.service.dto;

import java.util.List;

public class InnumAllDTO {
    List<InnumKechengDTO> kecheng;
    List<InnumSysDTO> haoma;

    public List<InnumKechengDTO> getKecheng() {
        return kecheng;
    }

    public void setKecheng(List<InnumKechengDTO> kecheng) {
        this.kecheng = kecheng;
    }

    public List<InnumSysDTO> getHaoma() {
        return haoma;
    }

    public void setHaoma(List<InnumSysDTO> haoma) {
        this.haoma = haoma;
    }
}
