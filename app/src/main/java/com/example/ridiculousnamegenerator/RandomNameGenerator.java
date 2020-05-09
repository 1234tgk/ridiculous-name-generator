package com.example.ridiculousnamegenerator;

import com.mifmif.common.regex.Generex;

public class RandomNameGenerator {
    // empty constructor

    public String generateName() {
        StringBuilder builder = new StringBuilder();
        Generex generex = new Generex("([a-z]|[bdfghjklmnpqrstvwxz][rlk])?([aeiouy])([bdfghjklmnpqrstvwxz]|ng|ll)?");

        int i = 0;
        boolean randomFlag;
        do {
            ++i;

            // create a syllabus
            String syllable = generex.random();
            // append it to StringBuilder
            builder.append(syllable);

            double numberFlag = Math.floor(Math.random() * 2);
            randomFlag = numberFlag == 0;
        } while (i < 3 && randomFlag);

        return builder.toString();
    }

    public static void main(String[] args) {
        RandomNameGenerator test = new RandomNameGenerator();
        System.out.println(test.generateName());
    }
}
