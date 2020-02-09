package hua.api;

import hua.objects.Student;
import hua.objects.StudentLogin;
import hua.objects.StudentsRequests;
import hua.objectsDao.*;
import hua.security.AESCrypt;
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
        id = AESCrypt.decrypt(id);
        if(housingScoreDao.getStudentPosById(Integer.valueOf(id)) >0) {
            return new ResponseEntity<>(AESCrypt.encrypt(String.valueOf(housingScoreDao.getStudentPosById(Integer.valueOf(id)))).toString(), HttpStatus.OK);
        }

        return new ResponseEntity<>(AESCrypt.encrypt("-1") , HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> login(@RequestBody StudentLogin studentLogin ){
        //Decrypt
        studentLogin.setMail(AESCrypt.decrypt(studentLogin.getMail()));
        studentLogin.setPassword(AESCrypt.decrypt(studentLogin.getPassword()));
        //End Decryption

        if(studentLoginDao.login(studentLogin)){
            Student student = studentsDao.getStudentIdByMail(studentLogin.getMail());
           return new ResponseEntity<>(student , HttpStatus.OK);
        }

        return new ResponseEntity<>(new Student() , HttpStatus.FORBIDDEN);
    }

    @PostMapping("/request/housing")
    public void requestHousing(@RequestBody StudentsRequests studentsRequest){
        //Decrypt
        studentsRequest.setId(AESCrypt.decrypt(String.valueOf(studentsRequest.getId())));
        studentsRequest.setBrothers(AESCrypt.decrypt(String.valueOf(studentsRequest.getBrothers())));
        studentsRequest.setDepartment(AESCrypt.decrypt(studentsRequest.getDepartment()));
        studentsRequest.setSemester(AESCrypt.decrypt(String.valueOf(studentsRequest.getSemester())));
        studentsRequest.setIncome(AESCrypt.decrypt(String.valueOf(studentsRequest.getIncome())));
        studentsRequest.setFromAnotherCity(AESCrypt.decrypt(String.valueOf(studentsRequest.getFromAnotherCity())));
        studentsRequest.setHousingYears(AESCrypt.decrypt(String.valueOf(studentsRequest.getHousingYears())));
        //End Decryption

        studentsRequestsDao.addRequest(studentsRequest);
        System.out.println("A housing request had been added");
    }

    @PostMapping("/info/change")
    public ResponseEntity<Boolean> infoChange(@RequestBody Student student){
        //Decrypt
        student.setAddress(AESCrypt.decrypt(student.getAddress()));
        student.setPhoneNumber(AESCrypt.decrypt(student.getPhoneNumber()));
        //End Decryption

        studentsDao.updateStudent(student);
        System.out.println("A student's info has been updated");

        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    //dump for tests
    @GetMapping(value = "/dump" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> dumpData(){
        studentLoginDao.insertSomeUsers();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value ="/can-request")
    public ResponseEntity<String> isStudentEnabled(@RequestBody String student_id){
        String encrypted_id = AESCrypt.decrypt(student_id);
        Boolean isEnabled = studentsHousingDao.isEnabled(Integer.valueOf(encrypted_id));
        String encryptedMessage = AESCrypt.encrypt(String.valueOf(isEnabled));

        return new ResponseEntity<>(encryptedMessage, HttpStatus.OK);
    }





}
