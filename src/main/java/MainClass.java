import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainClass {
    public void main(String poly) {
//        Scanner scanner = new Scanner(System.in);
//        String poly = scanner.nextLine();
        ArrayList<Item> items = new GetItems().getArrayOfItems(poly); //此时得到的已经求过导的项
        //接下来进行合并同类项。
        Collection<Item> itemsOfMergedTemp = new Merge().MergeItems(items);
        List<Item> itemsOfMerged = new ArrayList<Item>(itemsOfMergedTemp);
        Collections.sort(itemsOfMerged);
        StringBuilder finalResult = new StringBuilder();
        for (Item item:itemsOfMerged) {
            finalResult.append(new Print().printOneItem(item));
        }
        finalResult = new StringBuilder(finalResult.toString().replaceAll("^\\+", ""));
        if (finalResult.toString().equals("")) {
            System.out.println("0");   
        } else {
            System.out.println(finalResult);
        }

    }
}
