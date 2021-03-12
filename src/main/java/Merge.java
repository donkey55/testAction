import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Merge {
    public Collection<Item> MergeItems(ArrayList<Item> items) {
        HashMap<BigInteger,Item> itemHashMap = new HashMap<BigInteger, Item>();
        for (Item item:items) {
            BigInteger temp = item.getPower();
            if (!itemHashMap.containsKey(temp)) {
                itemHashMap.put(temp,item);
            } else {
                itemHashMap.get(temp).setCoefficient(item.getCoefficient());
            }
        }
        return itemHashMap.values();
    }

}
