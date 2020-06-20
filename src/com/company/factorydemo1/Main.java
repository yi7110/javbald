package com.company.factorydemo1;

/**
 * com.company.factorydemo1
 *
 * @author Liuzf
 * @date 2020-06-20 12:51:11
 */
public class Main {
    public static void main (String[] args) {
        BoxFactory bf = new BoxFactory();
        bf.getBox("red");
        bf.getBox("black");
    }
}
