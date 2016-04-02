package kz.blindbat.rateparser.util;

import org.htmlcleaner.TagNode;

import java.util.List;

import static kz.blindbat.rateparser.util.ParserUtils.getDouble;

/**
 * Created by Kuan on 02.04.2016.
 */
public class RateParsingStrategy {

    private String source;
    private String currency;
    private List<ParsingStep> buyRateSteps;
    private List<ParsingStep> sellRateSteps;

    public RateParsingStrategy(String source, List<ParsingStep> buyRateSteps, List<ParsingStep> sellRateSteps) {
        this.source = source;
        this.buyRateSteps = buyRateSteps;
        this.sellRateSteps = sellRateSteps;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<ParsingStep> getBuyRateSteps() {
        return buyRateSteps;
    }

    public void setBuyRateSteps(List<ParsingStep> buyRateSteps) {
        this.buyRateSteps = buyRateSteps;
    }

    public List<ParsingStep> getSellRateSteps() {
        return sellRateSteps;
    }

    public void setSellRateSteps(List<ParsingStep> sellRateSteps) {
        this.sellRateSteps = sellRateSteps;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
