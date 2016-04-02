package kz.blindbat.rateparser.util;

import org.htmlcleaner.TagNode;

import static kz.blindbat.rateparser.util.ParserUtils.*;

/**
 * Created by Kuan on 02.04.2016.
 */
public class ParsingStep {
    public static final int GET_TABLE = 1;
    public static final int GET_TR = 2;
    public static final int GET_TD = 3;

    private int parserUtil;
    private int index = 0;
    private boolean isRecursive = false;

    public ParsingStep(int parserUtil) {
        this.parserUtil = parserUtil;
    }

    public ParsingStep(int parserUtil, int index, boolean isRecursive) {
        this.parserUtil = parserUtil;
        this.index = index;
        this.isRecursive = isRecursive;
    }

    public ParsingStep(int parserUtil, int index) {
        this.parserUtil = parserUtil;
        this.index = index;
    }

    public ParsingStep(int parserUtil, boolean isRecursive) {
        this.parserUtil = parserUtil;
        this.isRecursive = isRecursive;
    }

    public TagNode perform(TagNode node) {
        switch (parserUtil) {
            case GET_TABLE:
                return getTable(node, index, isRecursive);
            case GET_TR:
                return getTr(node, index, isRecursive);
            case GET_TD:
                return getTd(node, index, isRecursive);
        }
        return null;
    }
}
