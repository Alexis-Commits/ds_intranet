package hua.helper;

import hua.objects.StudentHousing;

import java.util.List;

public class StudentsHelperMethods {

    public StudentsHelperMethods() {}

    public  boolean isEnabled(List<StudentHousing> studentHousingList , int id){

       for(StudentHousing studentHousing : studentHousingList){
           if(studentHousing.getId()==id){
               return true;
           }
       }

        return false;
    }

}
