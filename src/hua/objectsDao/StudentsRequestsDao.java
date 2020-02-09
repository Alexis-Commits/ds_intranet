package hua.objectsDao;

import hua.objects.StudentsRequests;

import java.util.List;

public interface StudentsRequestsDao {
    public List<StudentsRequests> getRequests() ;
    public List<StudentsRequests> getRequestsByDepartment(String department) ;
    public void acceptRequest(String id);
    public void addRequest(StudentsRequests studentsRequest);
}
