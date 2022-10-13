package com.line;

import com.line.domain.Hospital;
import com.line.parser.HostpitalParser;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HostpitalParser());
        String filename = "C:\\Users\\82104\\Desktop\\서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = hospitalLineReader.readLine(filename);


        System.out.println(hospitals.size());
        for(Hospital h : hospitals) {
            System.out.println(h.getId());
        }

    }
}
