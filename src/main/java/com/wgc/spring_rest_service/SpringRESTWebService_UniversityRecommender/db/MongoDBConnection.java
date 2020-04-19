package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.Survey;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.SurveyResult;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.University;
import org.bson.Document;
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
    public List<University> findByState(String state) {
        FindIterable<Document> iterable = db.getCollection("university_data").find(eq("state", state));
        int i = 0;
        List<University> res = new LinkedList<>();
        for(Document document: iterable) {
                i++;
                University university = new University();
                university.setName(document.getString("name"));
                university.setState(document.getString("state"));
                university.setControl(document.getString("control"));
                university.setLocation(document.getString("location"));
                university.setPercent_admittance(document.getString("percent_admittance"));
                university.setPercent_enrolled(document.getString("percent_enrolled"));
                university.setNo_applicants(document.getString("no_applicants"));
                university.setSat_verbal(document.getString("sat_verbal"));
                university.setSat_math(document.getString("sat_math"));
                university.setExpenses(document.getString("expenses"));
                university.setPercent_financial_aid(document.getString("percent_financial_aid"));
                university.setMale_female_ratio(document.getString("male_female_ratio"));
                university.setAcademics_scale(document.getString("academics_scale"));
                university.setSocial_scale(document.getString("social_scale"));
                university.setQuality_of_life_scale(document.getString("quality_of_life_scale"));
                res.add(university);
        };
        System.out.println("found university document size = " + i);
        return res;
    }

    public University findUniversityByName( String name) {
        return null;
    }

    public boolean addUniversity( University university) {
        return true;
    }

    public boolean updateUniversity( University university) {
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
