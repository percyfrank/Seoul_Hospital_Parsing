package com.line.domain;

public class Hospital {

    private String id;
    private String address;
    private String district;
    private String category;
    private String emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address,String category, String emergencyRoom, String name,String subdivision) {
        this.id = id;
        this.address = address;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
        this.setDistrict();
    }

    // SQL 쿼리문으로 변경
    public String toSqlQuery() {

        String sql = "";
        sql = "(" + this.id + "," + this.address + "," + this.district + ","
                + this.category + "," + this.emergencyRoom + "," + this.name + ",\"" + this.subdivision + "\"),\n";

        return sql;
    }

    // '구'까지의 정보는 address에서 파싱
    public void setDistrict() {
        String[] splitted = address.split(" ");
        this.district = String.format("%s %s\"",splitted[0],splitted[1]);
    }

//    public void setSubdivision() {
//        String[] subdivison = {"내과", "외과", "소아", "피부", "성형", "정형외과", "척추", "교정", "산부인과",
//                "관절", "봉합", "화상", "골절", "영유아", "안과", "가정의학과", "비뇨기과", "치과"};
//
//        for(String division : subdivison) {
//            if(name.contains(division)) {
//                this.subdivision = division;
//            } else {
//                this.subdivision = null;
//            }
//        }
//    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public String getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    //        public List<Hospital> readAndParse(String filename) {
//        ArrayList<Hospital> result = new ArrayList<>();
//
//        return result;
//    }


}
