package LI;

import java.util.Vector;

public class product {
    String name;
    String num;
    String price;

    public product(String name, String num, String price) {
        this.name = name;
        this.num = num;
        this.price = price;
    }

    static Vector<product> products = new Vector<>();

    public static void productlict(String name, String num, String price) {
        product p = new product(name, num, price);
        products.add(p);
    }

    public static void print() {
        for (product p : products) {
            System.out.println(p.name);
        }
    }

    public static void main(String[] args) {
        for (product p : products) {
            System.out.println(p.name);
        }
    }
}
