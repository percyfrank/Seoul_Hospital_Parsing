package com.line.domain;

public class Hospital {

    private String id;
    private String address;
    private String district;
    private String category;
    private String emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String district, String category, String emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public Hospital(String id) {
        this.id = id.replaceAll("\"","");
    }

    public String getId() {
        return id;
    }

//        public List<Hospital> readAndParse(String filename) {
//        ArrayList<Hospital> result = new ArrayList<>();
//
//        return result;
//    }


}
