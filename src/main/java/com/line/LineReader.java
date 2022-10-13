package com.line;

import com.line.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {

    Parser<T> parser;

    boolean isRemoveColumnName = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    List<T> readLine(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str = "";
        if(isRemoveColumnName) {
            br.readLine();
        }
        while((str = br.readLine()) != null) {
            result.add(parser.parse(str));
        }
        return result;
    }

//    public static void main(String[] args) throws IOException {
//        String filename = "C:\\Users\\82104\\Desktop\\서울시 병의원 위치 정보.csv";
////        LineReader lr = new LineReader();
//        List<String> lines = lr.readLine(filename);
//        System.out.println(lines.size());
//    }
}
