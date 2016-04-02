package kz.blindbat.rateparser.util;

import kz.blindbat.rateparser.Rates;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import static kz.blindbat.rateparser.util.ParserUtils.getDouble;

/**
 * Created by Kuan on 02.04.2016.
 */
public abstract class AbstractParser {
    protected HtmlCleaner cleaner = new HtmlCleaner();
    protected static URL ratesUrl;
    private List<RateParsingStrategy> parsingStrategies;
    protected List<Rates> ratesList;
    private TagNode rootNode;

    public abstract void retrieveRates();

    public AbstractParser() {
        try {
            this.rootNode = cleaner.clean(ratesUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void applyParsing

    public static Double parse(TagNode rootNode, List<ParsingStep> steps) {
        if (steps.isEmpty()) return null;
        TagNode resultNode = null;
        if (steps.size() == 1)
             resultNode = steps.get(0).perform(rootNode);
        else {
            resultNode = rootNode;
            for (ParsingStep step : steps) {
                resultNode = step.perform(resultNode);
            }
        }
        return getDouble(resultNode);
    }

    public List<RateParsingStrategy> getParsingStrategies() {
        return parsingStrategies;
    }

    public void setParsingStrategies(List<RateParsingStrategy> parsingStrategies) {
        this.parsingStrategies = parsingStrategies;
    }

    public static URL getRatesUrl() {
        return ratesUrl;
    }

    public static void setRatesUrl(URL ratesUrl) {
        AbstractParser.ratesUrl = ratesUrl;
    }

    public List<Rates> getRatesList() {
        return ratesList;
    }

    public void setRatesList(List<Rates> ratesList) {
        this.ratesList = ratesList;
    }

    public HtmlCleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(HtmlCleaner cleaner) {
        this.cleaner = cleaner;
    }

    public TagNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TagNode rootNode) {
        this.rootNode = rootNode;
    }
}
