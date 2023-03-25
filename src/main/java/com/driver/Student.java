package com.driver;

public class Student {
    private int rollNo;
    private String studentName;
    private int age;

    public Student() {
    }

    public Student(int rollNo, String studentName, int age) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
