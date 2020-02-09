package hua.api;

import hua.objects.Student;
import hua.objects.StudentLogin;
import hua.objects.StudentsRequests;
import hua.objectsDao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    HousingScoreDao housingScoreDao;

    @Autowired
    StudentLoginDao studentLoginDao;

    @Autowired
    StudentsRequestsDao studentsRequestsDao;

    @Autowired
    StudentsDao studentsDao ;

    @Autowired
    StudentsHousingDao studentsHousingDao;

    @PostMapping("/score")
    public ResponseEntity<String> getScore(@RequestBody String id ){
        System.out.println(id);

        if(housingScoreDao.getStudentPosById(Integer.valueOf(id)) >0) {
            System.out.println(housingScoreDao.getStudentPosById(Integer.valueOf(id)));
            return new ResponseEntity<>(String.valueOf(housingScoreDao.getStudentPosById(Integer.valueOf(id))), HttpStatus.OK);

        }

        return new ResponseEntity<>("-1" , HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> login(@RequestBody StudentLogin studentLogin ){

        if(studentLoginDao.login(studentLogin)){
            Student student = studentsDao.getStudentIdByMail(studentLogin.getMail());
           return new ResponseEntity<>(student , HttpStatus.OK);
        }

        return new ResponseEntity<>(new Student() , HttpStatus.FORBIDDEN);
    }

    @PostMapping("/request/housing")
    public void requestHousing(@RequestBody StudentsRequests studentsRequest){
        studentsRequestsDao.addRequest(studentsRequest);
        System.out.println("A housing request had been added");
    }

    @PostMapping("/info/change")
    public ResponseEntity<Boolean> infoChange(@RequestBody Student student){
        studentsDao.updateStudent(student);
        System.out.println("A student's info has been updated");

        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    //dump , Call it to add new student to login table
    @GetMapping(value = "/insert" , produces = MediaType.APPLICATION_JSON_VALUE)
    public AtomicBoolean dumpData(){
        studentLoginDao.insertSomeUsers();

        return new AtomicBoolean(true);
    }

    @GetMapping(value ="/can-request")
    public ResponseEntity<Boolean> isStudentEnabled(@RequestBody String id){

        return new ResponseEntity<>(studentsHousingDao.isEnabled(Integer.valueOf(id)), HttpStatus.OK);
    }



}
