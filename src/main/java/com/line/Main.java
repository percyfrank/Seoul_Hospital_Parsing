package com.line;

import com.line.domain.Hospital;
import com.line.parser.HostpitalParser;
import com.sun.jdi.ShortType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HostpitalParser());
        String filename = "C:\\Users\\82104\\Desktop\\서울시 병의원 위치 정보1.csv";
        List<Hospital> hospitals = hospitalLineReader.readLine(filename);

        HostpitalParser hostpitalParser = new HostpitalParser();
        List<String> querys = new ArrayList<>();
        for(Hospital hospital : hospitals) {
            String query = hospital.toSqlQuery();
            querys.add(query);
        }

        String sql_file = "C:\\Users\\82104\\Desktop\\hospital_query.sql";
        File file = new File(sql_file);

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(String query : querys) {
            bw.write(query);
        }
        bw.close();


//        for (Hospital hospital : hospitals) {
//            System.out.printf("%s %s %s %s %s %s %s",hospital.getId(),hospital.getAddress(),hospital.getDistrict()
//            ,hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName(),hospital.getSubdivision());
//        }

//        System.out.println(hospitals.size());
//        for(Hospital h : hospitals) {
//            System.out.println(h.getId());
//        }

    }
}
