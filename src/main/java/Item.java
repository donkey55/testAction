import java.math.BigInteger;

public class Item implements Comparable<Item> {
    private BigInteger coefficient;
    private BigInteger power;

    Item(BigInteger coefficient, BigInteger power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    Item() {

    }

    public BigInteger getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigInteger coefficient) {
        this.coefficient = this.coefficient.add(coefficient);
    }

    public BigInteger getPower() {
        return power;
    }

    public void setPower(BigInteger power) {
        this.power = power;
    }

    @Override
    public String toString() {
        String ret;
        BigInteger a0 = new BigInteger(String.valueOf(0));
        BigInteger a1 = new BigInteger(String.valueOf(1));
        BigInteger a2 = new BigInteger(String.valueOf(-1));
        if (coefficient.equals(a0)) {
            ret = "0";
        } else if (power.equals(a0)) {
            ret = coefficient.toString();
        } else if (coefficient.equals(a1) & !power.equals(a1)) {
            ret = "x**" + power.toString();
        } else if (coefficient.equals(a1) & power.equals(a1)) {
            ret = "x";
        } else if (coefficient.equals(a2) & !power.equals(a1)) {
            ret = "-x**" + power.toString();
        } else if (coefficient.equals(a2) & power.equals(a1)) {
            ret = "-x";
        } else if (power.equals(a1)) {
            ret = coefficient.toString() + "*x";
        } else {
            ret = coefficient.toString() + "*x**" + power.toString();
        }
        return ret;
    }

    public int compareTo(Item o) {
        if (this.coefficient.compareTo(o.coefficient) > 0) {
            return -1;
        }
        if (this.coefficient.compareTo(o.coefficient) < 0) {
            return 1;
        }
        if (this.power.compareTo(o.power) > 0) {
            return -1;
        }
        if (this.power.compareTo(o.power) < 0) {

            return 1;
        }


        return 0;
    }

}
