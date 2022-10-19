package com.line.parser;

import com.line.domain.Hospital;

public class HostpitalParser implements Parser<Hospital> {

    /**
     * 병원 이름에서 세부 분과 추출을 위한 메서드
     */
    private String getSubdivision(String name) {
        String[] subdivison = {"내과","소아과", "피부", "성형외과", "정형외과", "척추", "교정", "산부인과",
                "관절", "봉합", "화상", "골절", "영유아", "안과", "가정의학과", "비뇨기과", "치과", "이비인후과","한의원","영상의학과"};

        // 세부 분과가 이름에 포함되어 있으면 리턴하고 아닐시 null 반환
        for(String subdiv : subdivison) {
            if(name.contains(subdiv)) {
                return subdiv;
            }
        }
        return "";
    }

    @Override
    public Hospital parse(String str) {
//        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");

        String subdivision = getSubdivision(splitted[10]);  // subdivision

        return new Hospital(splitted[0],splitted[1],splitted[2],splitted[6],splitted[10],subdivision);
    }
}
