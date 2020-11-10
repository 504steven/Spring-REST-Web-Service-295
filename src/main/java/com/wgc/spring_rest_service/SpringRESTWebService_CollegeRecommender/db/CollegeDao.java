package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.LinkedList;
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

    public College findCollegeById(int id) {
        FindIterable<Document> dbRes = db.getCollection(COLLEGE_COLLECTION).find( new Document("id", id));
        Iterator<Document> itr = dbRes.iterator();
        if(itr.hasNext()) {
            return docToCollege(itr.next());
        }
        return null;
    }

    public List<College> findCollegeByName(String name) {
        FindIterable<Document> dbRes = db.getCollection(COLLEGE_COLLECTION).find( new Document("$text"
                                        , new Document("$search", name)));
        Iterator<Document> itr = dbRes.iterator();
        List<College> res = new LinkedList<>();
        while(itr.hasNext()) {
            res.add( docToCollege( itr.next()));
        }
        return res;
    }

    public List<College> findCollegeInOrder(int num, int page, String orderField) {
        if(orderField == null) {
            orderField = "id";
        }
        int start = (page-1)*num+1;
//        int end = page * num;
        FindIterable<Document> dbRes = db.getCollection(COLLEGE_COLLECTION).find().sort( new Document(orderField, 1)).skip(start).limit(num);
        Iterator<Document> itr = dbRes.iterator();
        List<College> res = new LinkedList<>();
        while(itr.hasNext()) {
            res.add( docToCollege( itr.next()));
        }
        return res;
    }

    public List<College> findCollegeByLocation(Double lon, Double lat, Double radius) {
        Point currentLoc = new Point(new Position(lon, lat));

        // the results are sorted from nearest to farthest.
        FindIterable<Document> dbRes = db.getCollection(COLLEGE_COLLECTION).find(
                                                            // maxDis, minDis  in meter, but Accuracy is at km level.
                Filters.near("loc", currentLoc, radius, 0.0));
        Iterator<Document> itr = dbRes.iterator();
        List<College> res = new LinkedList<>();
        while(itr.hasNext()) {
            res.add( docToCollege(itr.next()));
        }
        return res;
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

    private College docToCollege(Document doc) {
        if(doc == null) {   return null;}
        College college = new College();
        college.setId(doc.getInteger("id"));
        college.setName(doc.getString("name"));

        List<Double> coords = doc.get("loc", Document.class).get("coordinates", List.class);
        college.setLon(coords.get(0));
        college.setLat(coords.get(1));

        college.setState(doc.getString("state"));
        college.setControl(doc.getString("control"));
        college.setUrbanization(doc.getString("urbanization"));
        college.setReligious_affiliation(doc.getString("religious_affiliation"));

        college.setOffers_associate_degree(doc.getBoolean("offers_associate_degree"));
        college.setOffers_bachelor_degree(doc.getBoolean("offers_bachelor_degree"));
        college.setOffers_master_degree(doc.getBoolean("offers_master_degree"));
        college.setOffers_doctor_degree_research_scholarship(doc.getBoolean("offers_doctor_degree_research_scholarship"));
        college.setOffers_doctor_degree_professional_practice(doc.getBoolean("offers_doctor_degree_professional_practice"));

        college.setTuition_and_fees(doc.getInteger("tuition_and_fees"));
        college.setApplicants_total(doc.getInteger("applicants_total"));
        college.setAdmissions_total(doc.getInteger("admissions_total"));
        college.setEnrolled_total(doc.getInteger("enrolled_total"));
        college.setPercent_admitted_total(doc.getInteger("percent_admitted_total"));
        college.setTotal_enrollment(doc.getInteger("total_enrollment"));
        college.setUndergraduate_total_enrollment(doc.getInteger("undergraduate_total_enrollment"));
        college.setGraduate_total_enrollment(doc.getInteger("graduate_total_enrollment"));
        college.setSat_reading_25th_percentile_score(doc.getInteger("sat_reading_25th_percentile_score"));
        college.setSat_reading_75th_percentile_score(doc.getInteger("sat_reading_75th_percentile_score"));
        college.setSat_math_25th_percentile_score(doc.getInteger("sat_math_25th_percentile_score"));
        college.setSat_math_75th_percentile_score(doc.getInteger("sat_math_75th_percentile_score"));
        college.setSat_writing_25th_percentile_score(doc.getInteger("sat_writing_25th_percentile_score"));
        college.setSat_writing_75th_percentile_score(doc.getInteger("sat_writing_75th_percentile_score"));
        college.setAct_25th_percentile_score(doc.getInteger("act_25th_percentile_score"));
        college.setAct_75th_percentile_score(doc.getInteger("act_75th_percentile_score"));

        return college;
    }
}
