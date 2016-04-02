package kz.blindbat.rateparser.util;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Kuan on 01.04.2016.
 */
public class ParserMain {
    private static final String URL = "http://www.eubank.kz/";
    private static final int EUB_SMARTBANK_TABLE = 1;
    private static final int EUB_RATES_TABLE = 3;

    private static final int EUB_USD_TR = 1;
    private static final int EUB_EUR_TR = 2;

    private static final int EUB_BUY_TD = 1;
    private static final int EUB_SELL_TD = 2;

    public ParserMain() {
    }

    public static void main(String[] args) {
        HtmlCleaner hc = new HtmlCleaner();
        TagNode rootNode = null;
        try {
            rootNode = hc.clean(new URL(URL));
            List<TagNode> exchangeNode = (List<TagNode>) rootNode.getElementListByAttValue("class", "exchange", true, true);
            if (!exchangeNode.isEmpty()) {
                System.out.println("USD: "+ ParserUtils.getDouble(ParserUtils.getTd(ParserUtils.getTr(ParserUtils.getTable(exchangeNode.get(0), EUB_SMARTBANK_TABLE, false),EUB_USD_TR, true),EUB_BUY_TD, false)));
                List<TagNode> tables = (List<TagNode>) exchangeNode.get(0).getElementListByName("table", false);
                TagNode smartbankTable = tables.get(1);
                Double usdRate = Double.parseDouble(smartbankTable.getElementListByName("td", true).get(EUB_SELL_TD).getText().toString().replace(',','.'));
                System.out.println("usdRate: "+usdRate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
