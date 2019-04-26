package model;

public class Stock {
    private String serial;
    private String code;
    private String name;
    private String price;
    private String updown;
    private String updownPrice;
    private String turnover;
    private String volRatio;
    private String amplitude;
    private String vol;
    private String tradeable;
    private String marketValue;
    private String PE;

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getConcept() {
        return concept;
    }

    private String concept;

    public String getSerial() {
        return serial;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getUpdown() {
        return updown;
    }

    public String getUpdownPrice() {
        return updownPrice;
    }

    public String getTurnover() {
        return turnover;
    }

    public String getVolRatio() {
        return volRatio;
    }

    public String getAmplitude() {
        return amplitude;
    }

    public String getVol() {
        return vol;
    }

    public String getTradeable() {
        return tradeable;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public String getPE() {
        return PE;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUpdown(String updown) {
        this.updown = updown;
    }

    public void setUpdownPrice(String updownPrice) {
        this.updownPrice = updownPrice;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public void setVolRatio(String volRatio) {
        this.volRatio = volRatio;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public void setTradeable(String tradeable) {
        this.tradeable = tradeable;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public void setPE(String PE) {
        this.PE = PE;
    }
}
