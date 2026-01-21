
package com.gradescope.gradenator;
import java.io.File;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        // Variables
        System.out.println("File Name?");
        Scanner filescanner = new Scanner(System.in);
        File file = new File(filescanner.next());
        filescanner = new Scanner(file);

        String linestring = "";
        String[] splitstring;
        double avg = 0.0;
        double totalavg = 0.0;
        double weight = 0.0;
        double totalweight = 0;

        // File line loop
        while (filescanner.hasNext()) {
            linestring = filescanner.nextLine();
            splitstring = linestring.split(";");
            avg = integerprocessing(splitstring[0]);
            weight = Integer.parseInt(splitstring[2].substring(1, splitstring[2].indexOf('%')));
            totalavg += avg * (weight/100);
            totalweight += weight;
            System.out.format(splitstring[1] + "; " + weight + "%%; avg= %.1f \n", avg);
        }
        System.out.format("TOTAL = %.1f%% out of " + totalweight, totalavg);
    }

    public static double integerprocessing(String values) {
        double total = 0;
        String[] num = values.split(" ");
        for (String num1 : num) {
            total += Integer.parseInt(num1);
        }
        return total / num.length;
    }
}