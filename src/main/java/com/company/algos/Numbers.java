package com.company.algos;

import com.company.other.Student;
import com.company.other.Triangle;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Maciek on 2017-03-08.
 */
public class Numbers {
    private String determineType(String number) {
        try {
            byte byteNum = Byte.parseByte(number);
            return "byte";
        } catch (Exception ex) {
            try {
                short shortNum = Short.parseShort(number);
                return "short";
            } catch (Exception ex1) {
                try {
                    int intNum = Integer.parseInt(number);
                    return "int";
                } catch (Exception ex2) {
                    try {
                        long longNum = Long.parseLong(number);
                        return "long";
                    } catch (Exception ex3) {
                        return "none";
                    }
                }
            }
        }
    }

//    private String initials(String name) {
//        String[] words = name.split(" ");
//        String initials = "";
//        String[] surname = words[words.length - 1].split("");
//        for (int i = 0; i < words.length - 1; i++) {
//            initials += Character.toUpperCase(words[i].charAt(0)) + ".";
//        }
//
//        for (int i = 0; i < surname.length; i++) {
//            if (i == 0) {
//                surname[i] = surname[i].toUpperCase();
//            }
//        }
//
//        return initials + String.join("", surname);
//    }

    public String longest(String s1, String s2) {
        // your code
        String sorted = "";

        for (int i = 0; i < s1.length(); i++) {

        }


        return sorted;
    }

//    public static ToDoubleFunction<Triangle> f =
//            t -> {
//                double tArea = 0.5 * (t.base * t.height);
//                t.setArea(tArea);
//                return tArea;
//            };
//
//    public Function<Student, Boolean> isStudent() {
//        return student -> student.getFullName().equals("John Smith") && student.studentNumber.equals("js123");
//    }
//
//    public static IntUnaryOperator create(int addTo) {
//
//        return i -> i + addTo;
//    }

    public static char findMissingLetter(char[] array) {
        int charCounter;
        char missing = ' ';

        for (int i = 0; i < array.length - 1; i++) {
            charCounter = array[i];
            if (charCounter + 1 != array[i + 1]) {
                missing = (char) (charCounter + 1);
            }
        }
        return missing;

    }

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int toSave = startPriceOld - startPriceNew, monthCount = 0;
        BigDecimal percentLoss = BigDecimal.valueOf(percentLossByMonth / 100).setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println(percentLoss.toString());
        BigDecimal priceOld = BigDecimal.valueOf(startPriceOld);
        BigDecimal priceNew = BigDecimal.valueOf(startPriceNew);
        BigDecimal saved = BigDecimal.ZERO;
        BigDecimal savings;

        if(toSave >= 0){
            return new int[]{0, toSave};
        }

        while(priceOld.add(saved).compareTo(priceNew) < 0){
            monthCount++;
            if(monthCount % 2 == 0 && monthCount > 0){
                percentLoss = percentLoss.add(BigDecimal.valueOf(0.005));
            }
            priceOld = priceOld.subtract(priceOld.multiply(percentLoss));
            priceNew = priceNew.subtract(priceNew.multiply(percentLoss));
            saved = saved.add(BigDecimal.valueOf(savingperMonth));
            System.out.println(priceOld.toString());
            System.out.println(priceNew.toString());
            System.out.println(saved.toString());


        }
        savings = (priceOld.add(saved)).subtract(priceNew);
        System.out.println(savings.toString());

        return new int[]{monthCount, savings.setScale(0, BigDecimal.ROUND_DOWN).intValueExact()};
    }

    public static int[] nbMonths2(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int month = 1;
        int savings = 0;
        double startPriceOldD = (double) startPriceOld;
        double startPriceNewD = (double) startPriceNew;
        while (startPriceNewD > (startPriceOldD + savings)) {
            if (month % 2 == 0)  percentLossByMonth += .5d;
            startPriceOldD *= (1 - percentLossByMonth / 100);
            startPriceNewD *= (1 - percentLossByMonth / 100);
            savings += savingperMonth;
            month++;
        }
        return new int[] { --month,  (int) Math.round((startPriceOldD + savings) - startPriceNewD) };
    }

    public static int[][] cartesianNeighbor(int x, int y){
        int[][] points = new int[8][2];
        int xCheck = x, yCheck = y;
        x--;
        y--;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points[i].length; j++){
                if(x == xCheck && y == yCheck){
                    continue;
                }
                points[i][0] = x;
                points[i][1] = y;
            }
            x++;
            y++;
        }
        System.out.println(Arrays.toString(points));
        return points;
    }

    public static boolean hasUniqueChars(String str) {
        if(str == null || str.isEmpty()){
            return true;
        }
        String toCheck;
        for(int i = 0; i < str.length(); i++){
            toCheck = str;
            char checked = str.charAt(i);
            toCheck = toCheck.replaceFirst(String.valueOf(checked), "");
            if(toCheck.contains(String.valueOf(checked))){
                return false;
            }
        }

        return true;
    }

//    public static String vertMirror (String strng) {
//        String[] toMirror = strng.split("([\])\g");
//
//        for(int i = 0; i < toMirror.length; i++){
//            String mirror = "";
//            for(int j = toMirror[i].length() - 1; j >= 0; j--){
//                mirror += toMirror[i].charAt(j);
//            }
//
//            toMirror[i] = mirror;
//        }
//
//        return String.join("\\", toMirror);
//    }
//
//    public static String horMirror (String strng) {
//        String[] toMirror = strng.split("([\])\g");
//
//        for(int i = 0; i < toMirror.length / 2; i++){
//            String temp = "";
//            temp = toMirror[i];
//            toMirror[i] = toMirror[(toMirror.length - 1) - i];
//            toMirror[(toMirror.length - 1) - i] = temp;
//        }
//
//        return String.join("\\", toMirror);
//    }

}
