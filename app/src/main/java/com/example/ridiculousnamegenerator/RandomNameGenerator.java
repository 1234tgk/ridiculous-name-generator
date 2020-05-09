package com.example.ridiculousnamegenerator;

import com.mifmif.common.regex.Generex;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RandomNameGenerator {
    final private Set<Character> CONFLICT_CHARACTER = new HashSet<>(Arrays.asList('b', 'd', 'k', 'q', 'v', 'w'));

    // empty constructor

    public String generateName() {
        StringBuilder builder = new StringBuilder();
        Generex generex = new Generex("([a-z]|[bdfghjklmnpqrstvwxz][rlkh])?([aeiouy])([bdfghjklmnpqrstvwxz]|ng|ll)?");

        int i = 0;
        boolean randomFlag;
        do {
            ++i;

            // create a syllabus
            String syllable = generex.random();

            // append it to StringBuilder
            builder.append(syllable);

            // randomly generate flag to true or false
            double numberFlag = Math.floor(Math.random() * 2);
            randomFlag = numberFlag == 0;
        } while (i < 3 && (randomFlag || builder.length() < 4));

        // add in '\'' if char seq becomes awkward
        for (int j = 1 ; j < builder.length() ; j++) {
            if (CONFLICT_CHARACTER.contains(builder.charAt(j)) && builder.charAt(j) == builder.charAt(j - 1))
                builder.insert(j, '\'');
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        RandomNameGenerator test = new RandomNameGenerator();
        System.out.println(test.generateName());
    }
}
