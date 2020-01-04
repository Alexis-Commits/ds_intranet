package hua.algorithms;

import hua.objects.StudentsRequests;

public class HousingAlgorithm {
    public static int calcScore(StudentsRequests request){
        int score= 0 ;

        int income = request.getIncome();
        int studyingBrothers = request.getBrothers();
        int fromAnotherCity=request.getFromAnotherCity(); // 0 false  or 1 true
        int semester = request.getSemester();
        int alreadyHousingYears = request.getHousingYears();

        //TODO: Create algorithm

        return score;
    }
}
