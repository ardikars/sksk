package com.example;

public class IPCalculation {
    private String courseName;
    private int sks;
    private String grade;
    private int valueIncerement;
    private int sksIncrement;

    public void setCourseName(String matkulName){
        this.courseName = matkulName;
    }

    public void setSks(int sks) {
        this.sks = sks;
        this.sksIncrement += sks;
    }

    public void setGrade(String grade){
        this.grade = grade;

        switch(this.grade){
            case "A":{
                this.valueIncerement+=this.sks*4;
                break;
            }
    
            case "B":{
                this.valueIncerement+=this.sks*3;
                break;
            }
    
            case "C":{
                this.valueIncerement+=this.sks*2;
                break;
            }
    
            case "D":{
                this.valueIncerement+=this.sks*1;
                break;
            }
    
            default:{
                System.out.println("Garde Is Not Valid");
            }
        }
    }

    public float getclacIP() {
        return (float) this.valueIncerement/(float) this.sksIncrement;
    }

}
