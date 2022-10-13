package com.line.parser;

import com.line.domain.Hospital;

public class HostpitalParser implements Parser<Hospital> {


    private String replaceAllQuot(String str) {
        return str.replaceAll("\"", "");
    }
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");

        String[] splitted_address = splitted[1].split(" ");
        String district = splitted_address[0] + " " + splitted_address[1];

        return new Hospital(replaceAllQuot(splitted[0]),replaceAllQuot(splitted[1]),replaceAllQuot(district),
                replaceAllQuot(splitted[2]),replaceAllQuot(splitted[6]),replaceAllQuot(splitted[10]));
    }
}
