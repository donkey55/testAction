import java.math.BigInteger;

public class Print {
    public String printOneItem(Item item) {
        if (item.getCoefficient().compareTo(BigInteger.valueOf(0)) < 0) {
            return item.toString();
        } else if (item.getCoefficient().compareTo(BigInteger.valueOf(0)) > 0) {
            return "+" + item.toString();
        } else {

            return "";
        }

    }
}
