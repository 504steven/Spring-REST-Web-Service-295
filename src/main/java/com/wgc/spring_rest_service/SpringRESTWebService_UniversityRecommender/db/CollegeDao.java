package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollegeDao {
    private static String COLLEGE_COLLECTION = "colleges";
    @Autowired
    MongoDatabase db;

    public boolean saveCollege(College college) {
        return true;
    }

    public boolean updateCollege(College college) {
        return true;
    }

    public College getCollege(int collegeId) {
        return null;
    }

    public List<College> findCollegeByName(String name) {
        return null;
    }

    public List<College> findCollegeInOrder(Integer num, String orderField) {
        return null;
    }

    public List<College> findCollegeByLocation(Double lon, Double lat, Double radius) {
        Point currentLoc = new Point(new Position(lon, lat));

        // the results are sorted from nearest to farthest.
        FindIterable<Document> results = db.getCollection(COLLEGE_COLLECTION).find(
                Filters.near("loc", currentLoc, radius, 0.0));
        return null;
    }

//    public List<College> findByState(String state) {
//        FindIterable<Document> iterable = db.getCollection("university_data").find(eq("state", state));
//        int i = 0;
//        List<College> res = new LinkedList<>();
//        for(Document document: iterable) {
//            i++;
//            College college = new College();
//            college.setName(document.getString("name"));
//            college.setState(document.getString("state"));
//            college.setControl(document.getString("control"));
//            college.setLocation(document.getString("location"));
//            college.setPercent_admittance(document.getString("percent_admittance"));
//            college.setPercent_enrolled(document.getString("percent_enrolled"));
//            college.setNo_applicants(document.getString("no_applicants"));
//            college.setSat_verbal(document.getString("sat_verbal"));
//            college.setSat_math(document.getString("sat_math"));
//            college.setExpenses(document.getString("expenses"));
//            college.setPercent_financial_aid(document.getString("percent_financial_aid"));
//            college.setMale_female_ratio(document.getString("male_female_ratio"));
//            college.setAcademics_scale(document.getString("academics_scale"));
//            college.setSocial_scale(document.getString("social_scale"));
//            college.setQuality_of_life_scale(document.getString("quality_of_life_scale"));
//            res.add(college);
//        };
//        System.out.println("found university document size = " + i);
//        return res;
//    }
}
