import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetItems {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> getArrayOfItems(String string) {
        String functionTerm = "x(\\s*\\*\\*\\s*[-+]?[0-9]+)?";
        String variableTerm = "([-+]?[0-9]+\\s*\\*\\s*)?" + functionTerm + "|" + "([+-]\\s*)?" +
                functionTerm;
        Pattern item = Pattern.compile("([+-]\\s*){0,2}" + variableTerm);
        Matcher matcher = item.matcher(string);
        while (matcher.find()) {
            //每找到一个便进行求导
            //System.out.println(matcher.group());
            items.add(new Derivative().derivativeOfPowerFunction(
                    getItemToBeDerivative(matcher.group())));
        }
        return this.items;

    }

    public String getItemToBeDerivative(String string) {
        String result = "";
        String temp = string.replaceAll("\\s|\\+", "");
        result = temp.replaceAll("--", "");
        return result;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
