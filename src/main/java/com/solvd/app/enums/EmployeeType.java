package com.solvd.app.enums;

public enum EmployeeType {

    FULL_TIME("Full-time", 40),
    PART_TIME("Part-time", 20),
    CONTRACTOR("Contractor", 0);

    private final String type;
    private final int hours;

    private EmployeeType(String jobType, int workHours) {
        type = jobType;
        hours = workHours;
    }

    public String getType() {
        return type;
    }

    public int getHours() {
        return hours;
    }
}
