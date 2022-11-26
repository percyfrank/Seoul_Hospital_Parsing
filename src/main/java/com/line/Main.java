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
        String filename = "C:\\Users\\82104\\Desktop\\교안\\4주차 서울시 병의원 분석\\서울시 병의원 위치 정보1.csv";
        List<Hospital> hospitals = hospitalLineReader.readLine(filename);  // csv파일 읽기


        HostpitalParser hostpitalParser = new HostpitalParser();
        List<String> querys = new ArrayList<>();  // 쿼리문으로 변경된 문자열을 넣기 위한 리스트 생성
        for(Hospital hospital : hospitals) {
            String query = hospital.toSqlQuery(); // 파싱한 값을 쿼리문으로 변경
            querys.add(query);                    // 데이터 추가
        }

        String sql_file = "C:\\Users\\82104\\Desktop\\교안\\4주차 서울시 병의원 분석\\hospital_query.sql";
        File file = new File(sql_file); //파일 생성

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("INSERT INTO `seoul_hospital_location`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n"
                + "VALUES\n"); // INSERT INTO가 반복되면 데이터 입력 시간이 오래 걸리므로 처음에 INSERT문 파일에 쓰기
        for(String query : querys) {
            bw.write(query); // 쿼리문을 한줄 씩 파일에 저장
        }
        bw.close();


//        for (Hospital hospital : hospitals) {
//            System.out.printf("%s, %s, %s, %s, %s, %s, %s",hospital.getId(),hospital.getAddress(),hospital.getDistrict()
//            ,hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName(),hospital.getSubdivision());
//        }
//
//        System.out.println(hospitals.size());
//        for(Hospital h : hospitals) {
//            System.out.println(h.getId());
//        }

    }
}
