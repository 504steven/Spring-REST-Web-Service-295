package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/university")
public class CollegeController {

    @GetMapping("/FilteredUniversity")
    public List<College>  getFilteredUniversityInfo(@RequestParam String state, @RequestParam String control, @RequestParam String sat_verbal, @RequestParam String sat_math, @RequestParam String expenses) {
        int verbal = Integer.parseInt( sat_verbal);
        int math = Integer.parseInt( sat_math);
        int cost = Integer.parseInt( expenses);
        System.out.println("look up for " + state);
//        List<College> candidates = mongoDBConnection.findByState(state);
//        System.out.println("found university size， before filtering = " + candidates.size());
//        Iterator<College> iterator = candidates.iterator();
//        while(iterator.hasNext()) {
//            College cur = iterator.next();
//            if(cur.getSat_verbal() == null) {
//                cur.setSat_verbal("0");
//            }
//            if(cur.getSat_math() == null) {
//                cur.setSat_math("0");
//            }
//            if(cur.getExpenses() == null) {
//                cur.setExpenses("0");
//            }
//            if(verbal < Integer.parseInt(cur.getSat_verbal()) || math < Integer.parseInt(cur.getSat_math()) || cost+1000 < Integer.parseInt(cur.getExpenses()) || !control.equals(cur.getControl())) {
//                iterator.remove();
//            }
//        }
//        System.out.println("found university size = " + candidates.size());
        return  null;
    }

    @GetMapping()
    public List<College> findUniversityByName(@PathParam("keyword") String universityName) {
        return null;
    }

    public College getUniversityById(int id) {
        return null;
    }

    public boolean addUniversity(College college) {
        return true;
    }

    public boolean updateUniversity(College college) {
        return true;
    }


    @GetMapping("/test")
    public String test(){
        System.out.println("yyy");
        return "xx";
    }
}
