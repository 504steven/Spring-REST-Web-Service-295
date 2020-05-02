package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.Survey;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.SurveyResult;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBConnection {
    private String IP = "localhost";
    private int PORT = 27017;
    private final String DB_NAME = "designyourlife";
    private MongoClient mongoClient;
    private MongoDatabase db;

    public MongoDBConnection() {
//        this.mongoClient = new MongoClient(IP, PORT);
//        this.db = this.mongoClient.getDatabase(DB_NAME);
    }

    // university CRUD
    public List<College> findByState(String state) {
        FindIterable<Document> iterable = db.getCollection("university_data").find(eq("state", state));
        int i = 0;
        List<College> res = new LinkedList<>();
        for(Document document: iterable) {
                i++;
                College college = new College();
                college.setName(document.getString("name"));
                college.setState(document.getString("state"));
                college.setControl(document.getString("control"));
                college.setLocation(document.getString("location"));
                college.setPercent_admittance(document.getString("percent_admittance"));
                college.setPercent_enrolled(document.getString("percent_enrolled"));
                college.setNo_applicants(document.getString("no_applicants"));
                college.setSat_verbal(document.getString("sat_verbal"));
                college.setSat_math(document.getString("sat_math"));
                college.setExpenses(document.getString("expenses"));
                college.setPercent_financial_aid(document.getString("percent_financial_aid"));
                college.setMale_female_ratio(document.getString("male_female_ratio"));
                college.setAcademics_scale(document.getString("academics_scale"));
                college.setSocial_scale(document.getString("social_scale"));
                college.setQuality_of_life_scale(document.getString("quality_of_life_scale"));
                res.add(college);
        };
        System.out.println("found university document size = " + i);
        return res;
    }

    public College findUniversityByName(String name) {
        return null;
    }

    public boolean addUniversity( College college) {
        return true;
    }

    public boolean updateUniversity( College college) {
        return true;
    }

    //survey CRUD
    public List<String> getSurveyList() {
        return null;
    }

    public Survey findSurveyByName(String name) {
        return null;
    }

    public boolean addSurvey( Survey survey) {
        return true;
    }

    public boolean updateSurvey( Survey survey) {
        return true;
    }

    public Survey findSurveyResultByStudentId(int studentId) {
        return null;
    }

    public boolean addSurveyResult( SurveyResult surveyResult) {
        return true;
    }

    public boolean updateSurveyResult( SurveyResult surveyResult) {
        return true;
    }
}
