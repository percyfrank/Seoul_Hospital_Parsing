package com.line.domain;

public class Hospital {

    private String id;
    private String address;
    private String district;
    private String category;
    private String emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String district, String category, String emergencyRoom, String name) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
    }

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
