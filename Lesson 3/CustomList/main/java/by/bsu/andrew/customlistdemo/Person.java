package by.bsu.andrew.customlistdemo;

public class Person {
  String eName,cName,job;
  int imgID;


    public Person(String eName, String cName, String job,int imgID) {
        this.eName = eName;
        this.cName = cName;
        this.job = job;
        this.imgID = imgID;
    }


    @Override
    public String toString() {
        return  "eName='" + eName +
                ", cName='" + cName +
                ", job='" + job;
    }


}
