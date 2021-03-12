import java.math.BigInteger;

public class Derivative {
    public Item derivativeOfPowerFunction(String string) {
        Item result = new Item();
        BigInteger coefficientBefore;
        BigInteger powerBefore;
        BigInteger coefficientAfter;
        BigInteger powerAfter;
        String[] elements = string.split("\\*{1,2}");
        switch (elements.length) {
            case 1:
                if (elements[0].length() == 1) {
                    result = new Item(new BigInteger(String.valueOf(1)),
                            new BigInteger(String.valueOf(0)));
                } else {
                    result =  new Item(new BigInteger(String.valueOf(-1)),
                            new BigInteger(String.valueOf(0)));
                }
                break;
            case 2:
                if (elements[1].equals("x")) {
                    coefficientBefore = new BigInteger(getDeleteLeadingZero(elements[0]));
                    result = new Item(coefficientBefore,new BigInteger(String.valueOf(0)));
                } else if (elements[0].equals("-x")) {
                    powerBefore = new BigInteger(getDeleteLeadingZero(elements[1]));
                    powerAfter = powerBefore.add(BigInteger.valueOf(-1));
                    coefficientAfter = powerBefore.multiply(BigInteger.valueOf(-1));
                    result = new Item(coefficientAfter,powerAfter);
                } else {
                    powerBefore = new BigInteger(getDeleteLeadingZero(elements[1]));
                    result = new Item(powerBefore,powerBefore.add(BigInteger.valueOf(-1)));
                }
                break;
            case 3:
                coefficientBefore = new BigInteger(getDeleteLeadingZero(elements[0]));
                powerBefore = new BigInteger(getDeleteLeadingZero(elements[2]));
                coefficientAfter = coefficientBefore.multiply(powerBefore);
                powerAfter = powerBefore.add(BigInteger.valueOf(-1));
                result = new Item(new BigInteger(String.valueOf(coefficientAfter)),
                        new BigInteger(String.valueOf(powerAfter)));
                break;
            default:
        }
        return result;
    }

    public String deleteLeadingZero(String string) {
        return string.replaceAll("^0+", "");
    }

    public String getDeleteLeadingZero(String string) {
        String result = "";
        if (string.charAt(0) == '-') {
            result = result.concat(string.charAt(0) + deleteLeadingZero(string.substring(1)));
        }
        else {
            result = result.concat(deleteLeadingZero(string));
        }
        if (result.equals("") || result.equals("-")) {
            result = "0";
        }
        return result;
    }

}
