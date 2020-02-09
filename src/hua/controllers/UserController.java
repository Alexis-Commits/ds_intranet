package hua.controllers;


import hua.helper.StudentsHelperMethods;
import hua.objects.*;
import hua.objectsDao.HousingScoreDao;
import hua.objectsDao.StudentsDao;
import hua.objectsDao.StudentsHousingDao;
import hua.objectsDao.StudentsRequestsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    StudentsDao studentsDao;

    @Autowired
    StudentsHousingDao studentsHousingDao;

    @Autowired
    StudentsRequestsDao studentsRequestsDao;

    @Autowired
    HousingScoreDao housingScoreDao;


    @GetMapping("/students")
    public String studentsIndex(){
        return "students";
    }

    @GetMapping("/students/students-manager")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public String studentsManager(Model model){
        List<Student> studentList = studentsDao.getStudents();
        List<StudentHousing> studentsEnabledList = studentsHousingDao.getEnabledStudents();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("students" , studentList);
        model.addAttribute("studentsEnabled" , studentsEnabledList);
        model.addAttribute("helper" , helper);

        return "students-manager";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DIT')")
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DHEE')")
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DDNS')")
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

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DIT') or hasAuthority('ROLE_DDNS') or hasAuthority('ROLE_DDHE')")
    @GetMapping("/students/students-manager/enable/{id}")
    public String enableStudent(@PathVariable int id , HttpServletRequest request){
        studentsHousingDao.enableStudent(new StudentHousing(id , 1 ));
        String referer = request.getHeader("Referer");

        return "redirect:"+ referer;
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/students/students-requests")
    public String studentsRequests(Model model){
        List<StudentsRequests> requests = studentsRequestsDao.getRequests();
        List<HousingScore> scores = housingScoreDao.getStudentsScore();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("requests" , requests);
        model.addAttribute("scores" , scores);
        model.addAttribute("helper" , helper);

        return "students-requests";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DIT')")
    @GetMapping("/students/students-requests/dit")
    public String studentsRequestsDit(Model model){
        List<StudentsRequests> requests = studentsRequestsDao.getRequestsByDepartment("dit");
        List<HousingScore> scores = housingScoreDao.getStudentsScore();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("requests" , requests);
        model.addAttribute("scores" , scores);
        model.addAttribute("helper" , helper);

        return "students-requests";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DDNS')")
    @GetMapping("/students/students-requests/ddns")
    public String studentsRequestsDdns(Model model){
        List<StudentsRequests> requests = studentsRequestsDao.getRequestsByDepartment("ddns");
        List<HousingScore> scores = housingScoreDao.getStudentsScore();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("requests" , requests);
        model.addAttribute("scores" , scores);
        model.addAttribute("helper" , helper);

        return "students-requests";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DHEE')")
    @GetMapping("/students/students-requests/dhee")
    public String studentsRequestsDhee(Model model){
        List<StudentsRequests> requests = studentsRequestsDao.getRequestsByDepartment("dhee");
        List<HousingScore> scores = housingScoreDao.getStudentsScore();
        StudentsHelperMethods helper = new StudentsHelperMethods();
        model.addAttribute("requests" , requests);
        model.addAttribute("scores" , scores);
        model.addAttribute("helper" , helper);

        return "students-requests";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') or hasAuthority('ROLE_DIT') or hasAuthority('ROLE_DDNS') or hasAuthority('ROLE_DDHE')")
    @GetMapping("/students/students-requests/accept/{id}")
    public String AcceptRequest(@PathVariable String id , HttpServletRequest request){
        studentsRequestsDao.acceptRequest(id);
        String referer = request.getHeader("Referer");

        return "redirect:"+ referer;
    }


}
