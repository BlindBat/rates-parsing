package kz.blindbat.rateparser;

import java.util.List;

/**
 * Created by Kuan on 02.04.2016.
 */
public class Rates {
    private String source;
    List<Rate> rates;

    public Rates(String source, List<Rate> rates) {
        this.source = source;
        this.rates = rates;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
