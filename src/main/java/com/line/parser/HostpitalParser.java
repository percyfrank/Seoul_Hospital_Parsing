package com.line.parser;

import com.line.domain.Hospital;

public class HostpitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str) {
        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");

//        String[] splitted_address = splitted[1].split(" ");
//        String district = splitted_address[0] + " " + splitted_address[1];

        return new Hospital(splitted[0],splitted[1],splitted[2],splitted[6],splitted[10]);
    }
}
