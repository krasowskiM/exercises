package com.company.other;

import com.company.algos.Numbers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Maciek on 2017-02-23.
 */
public class StrangeCases {

    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if(phrase == null || phrase.isEmpty()){
            return null;
        }

        String[] split = phrase.split(" ");
        String joined;

        for(int i = 0; i < split.length; i++){
            String[] splitTwo = split[i].split("");
            for (int j = 0; j < splitTwo.length; j++){
                if(j != 0){
                    splitTwo[j] = splitTwo[j].toLowerCase();
                } else {
                    splitTwo[j] = splitTwo[j].toUpperCase();
                }
            }

            split[i] = String.join("", splitTwo);

        }

        joined = String.join(" ", split);

        return joined;
    }

    public static void main(String[] args){
        System.out.println(Numbers.hasUniqueChars("a b c"));
    }

    public static String ageInDays(int year, int month, int day) {
        // your code
        LocalDate birthDate = LocalDate.of(year, month, day);
        long days = ChronoUnit.DAYS.between(birthDate, LocalDate.now());
        return "You are " + days + " days old";
    }
}
