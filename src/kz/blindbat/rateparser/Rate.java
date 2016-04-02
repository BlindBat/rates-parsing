package kz.blindbat.rateparser;

import java.util.Date;

/**
 * Created by Kuan on 02.04.2016.
 */
public class Rate {
    public static final int BUY_RATE = 1;
    public static final int SELL_RATE = 2;

    private String currency;
    private Double buyRate;
    private Double sellRate;
    private Double averageRate;
    private Date date;

    public Rate(String currency, Double buyRate, Double sellRate, Double averageRate, Date date) {
        this.currency = currency;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
        this.averageRate = averageRate;
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Double buyRate) {
        this.buyRate = buyRate;
    }

    public Double getSellRate() {
        return sellRate;
    }

    public void setSellRate(Double sellRate) {
        this.sellRate = sellRate;
    }

    public Double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }

    public void setAverageRate() {
        this.averageRate = (this.buyRate + this.sellRate)/2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
