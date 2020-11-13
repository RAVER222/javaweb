package com.wyclass.Proctice;

public class Student {
  private String name;
  private int Chinese;
  private int math;
  private int english;

   public Student(){

   }

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        Chinese = chinese;
        this.math = math;
        this.english = english;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int  sum(){
        int sum =this.Chinese+this.math+this.english;
        return  sum;
    }
}
