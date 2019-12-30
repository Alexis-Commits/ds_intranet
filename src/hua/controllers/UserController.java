package hua.controllers;


import hua.helper.StudentsHelperMethods;
import hua.objects.*;
import hua.objectsDao.StudentsDao;
import hua.objectsDao.StudentsHousingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    StudentsDao studentsDao;

    @Autowired
    StudentsHousingDao studentsHousingDao;


    @GetMapping("/students")
    public String studentsIndex(){
        return "students";
    }

    @GetMapping("/students/students-manager")
    public String studentsManager(Model model){
        List<Student> studentList = studentsDao.getStudents();
        List<StudentHousing> studentsEnabledList = studentsHousingDao.getEnabledStudents();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("students" , studentList);
        model.addAttribute("studentsEnabled" , studentsEnabledList);
        model.addAttribute("helper" , helper);
        return "students-manager";
    }
    @GetMapping("/students/students-manager/dit")
    public String studentsManagerdit(Model model){
        List<Student> studentList = studentsDao.getStudentsByDepartment("dit");
        List<StudentHousing> studentsEnabledList = studentsHousingDao.getEnabledStudents();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("students" , studentList);
        model.addAttribute("studentsEnabled" , studentsEnabledList);
        model.addAttribute("helper" , helper);
        return "students-manager";
    }
    @GetMapping("/students/students-manager/dhee")
    public String studentsManagerdhee(Model model){
        List<Student> studentList = studentsDao.getStudentsByDepartment("dhee");
        List<StudentHousing> studentsEnabledList = studentsHousingDao.getEnabledStudents();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("students" , studentList);
        model.addAttribute("studentsEnabled" , studentsEnabledList);
        model.addAttribute("helper" , helper);
        return "students-manager";
    }
    @GetMapping("/students/students-manager/ddns")
    public String studentsManagerddns(Model model){
        List<Student> studentList = studentsDao.getStudentsByDepartment("ddns");
        List<StudentHousing> studentsEnabledList = studentsHousingDao.getEnabledStudents();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("students" , studentList);
        model.addAttribute("studentsEnabled" , studentsEnabledList);
        model.addAttribute("helper" , helper);
        return "students-manager";
    }

    @GetMapping("/students/students-manager/enable/{id}")
    public String enableStudent(@PathVariable int id ){
        studentsHousingDao.enableStudent(new StudentHousing(id , 1 ));

        return "redirect:/students/students-manager";
    }



}
