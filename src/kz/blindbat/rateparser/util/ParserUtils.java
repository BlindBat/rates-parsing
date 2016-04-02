package kz.blindbat.rateparser.util;

import org.htmlcleaner.TagNode;

import java.util.List;

/**
 * Created by Kuan on 01.04.2016.
 */
public class ParserUtils {

    public static TagNode getTable(TagNode rootNode, int index, boolean isRecursive) {
        List<TagNode> tables = (List<TagNode>) rootNode.getElementListByName("table", isRecursive);
        if (tables.isEmpty()) return null;
        return tables.get(index);
    }

    public static TagNode getTr(TagNode tableNode, int index, boolean isRecursive) {
        List<TagNode> tableRows = (List<TagNode>) tableNode.getElementListByName("tr", isRecursive);
        if (tableRows.isEmpty()) return null;
        return tableRows.get(index);
    }

    public static TagNode getTd(TagNode tableRowNode, int index, boolean isRecursive) {
        List<TagNode> tableCells = (List<TagNode>) tableRowNode.getElementListByName("td", isRecursive);
        if (tableCells.isEmpty()) return null;
        return tableCells.get(index);
    }

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

    public static Double getDouble(TagNode node) {
        try {
            return Double.parseDouble(node.getText().toString().replace(',','.'));
        } catch (NullPointerException e) {
            return 0.0;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
