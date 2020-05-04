package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.Survey;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyDao {

    public boolean saveSurvey(Survey survey) {
        return true;
    }

    public boolean updateSurvey(Survey survey) {
        return true;
    }

    public Survey getSurvey(int surveyId) {
        return null;
    }

}
