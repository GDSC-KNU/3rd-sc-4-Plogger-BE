package com.gdsc.plogger;

public enum ExpInfo {
    PLOGGING(3),
    TRASH(1);

    private int expInfo;

    private ExpInfo(int expInfo) {
        this.expInfo = expInfo;
    }

    public int getExpInfo() {
        return expInfo;
    }
}
