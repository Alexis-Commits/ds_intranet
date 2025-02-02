package hua.algorithms;

import hua.objects.StudentsRequests;

public class HousingAlgorithm {
    public static int calcScore(StudentsRequests request){
        int score= 0 ;
        int maxScore = 1000;

        int income = Integer.valueOf(request.getIncome());
        int studyingBrothers = Integer.valueOf(request.getBrothers());
        int fromAnotherCity=Integer.valueOf(request.getFromAnotherCity()); // 0 false  or 1 true
        int semester = Integer.valueOf(request.getSemester());
        int alreadyHousingYears = Integer.valueOf(request.getHousingYears());

        if(fromAnotherCity == 0 || semester > 8) {
            return score;
        }
        else {
            score += 50;

            if (income == 0) {
                score = maxScore;
                return score;
            }
            else if(income <10000){
                score += 100;
            }
            else if(income<15000){
                score += 30;
            }
        }
        for (int i=1; i<=studyingBrothers; i++ ){
            score += 20;
        }
        for (int i = alreadyHousingYears; i>0; i--){
            score -= 10;
        }
        return score;
    }
}
