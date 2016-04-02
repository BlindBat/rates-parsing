package kz.blindbat.rateparser;

import kz.blindbat.rateparser.util.AbstractParser;
import org.htmlcleaner.TagNode;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Kuan on 02.04.2016.
 */
public class EubParser extends AbstractParser {
    private static final int EUB_SMARTBANK_TABLE = 1;
    private static final int EUB_RATES_TABLE = 3;

    private static final int EUB_USD_TR = 1;
    private static final int EUB_EUR_TR = 2;

    private static final int EUB_BUY_TD = 1;
    private static final int EUB_SELL_TD = 2;

    public EubParser() {
        try {
            this.ratesUrl = new URL("http://www.eubank.kz/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void retrieveRates() {

    }
}
