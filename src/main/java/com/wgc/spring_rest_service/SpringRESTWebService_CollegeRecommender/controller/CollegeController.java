package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.CollegeDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin("*")
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeDao collegeDao;

    @ApiOperation(value = "find all college objets whose name include the keyword")
    @GetMapping("/name")
    public List<College> findCollegeByName(@RequestParam(value = "name") String name) {
        return collegeDao.findCollegeByName(name);
    }

    @GetMapping("/order")
    public List<College> findCollegeInOrder(@RequestParam(value = "num") Integer num, @RequestParam(value = "orderBy", required = false) String orderField ) {
        return collegeDao.findCollegeInOrder(num, orderField);
    }

    @GetMapping("/location")
    public List<College> findCollegeByLocation(@RequestParam("lat") Double lat, @RequestParam("lon") Double lon, @RequestParam("radius") Double radius ) {
        return collegeDao.findCollegeByLocation(lon, lat, radius);
    }


    @GetMapping("/FilteredCollege")
    public List<College>  getFilteredCollegeInfo(@RequestParam String state, @RequestParam String control, @RequestParam String sat_verbal, @RequestParam String sat_math, @RequestParam String expenses) {
        int verbal = Integer.parseInt( sat_verbal);
        int math = Integer.parseInt( sat_math);
        int cost = Integer.parseInt( expenses);
        System.out.println("look up for " + state);
//        List<College> candidates = mongoDBConnection.findByState(state);
//        System.out.println("found College size， before filtering = " + candidates.size());
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
//        System.out.println("found College size = " + candidates.size());
        return  null;
    }


}
