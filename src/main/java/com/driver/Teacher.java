package com.driver;

public class Teacher {
    private String teacherName;
    private int teacherAge;
    private String qualification;

    public Teacher() {
    }

    public Teacher(String teacherName, int teacherAge, String qualification) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.qualification = qualification;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
