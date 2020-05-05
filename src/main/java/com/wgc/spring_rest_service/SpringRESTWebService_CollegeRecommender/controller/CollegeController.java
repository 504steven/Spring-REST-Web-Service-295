package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.CollegeDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Api
@RestController
@CrossOrigin("*")
@RequestMapping("/college")
public class CollegeController {
    Logger logger = LoggerFactory.getLogger(CollegeController.class);

    @Autowired
    CollegeDao collegeDao;

    @ApiOperation(value = "find all college objets whose name include the keyword")
    @GetMapping("/name")
    public List<College> findCollegeByName(HttpServletRequest req, @RequestParam(value = "name") String name) {
        MDC.put("userInfo","User Id-" + req.getAttribute("userId"));
        logger.info(req.getRequestURI() + ": User is trying to find colleges with name = {} ...", name);
        List<College> res = collegeDao.findCollegeByName(name);
        logger.info("Found {} colleges with name = {}", res.size(), name);
        MDC.clear();
        return res;
    }

    @GetMapping("/order")
    public List<College> findCollegeInOrder(HttpServletRequest req, @RequestParam(value = "num") Integer num, @RequestParam(value = "page") Integer page, @RequestParam(value = "orderby", required = false) String orderField ) {
        MDC.put("userInfo","User Id-" + req.getAttribute("userId"));
        if(orderField == null) {    orderField = "id";}
        logger.info(req.getRequestURI() + ": User is trying to find colleges with num = {}, page = {}, orderby = {}", num, page, orderField);
        List<College> res = null;
        if(num <= 0 || page <= 0) {
            res = new LinkedList<>();
        }else {
            res = collegeDao.findCollegeInOrder(num, page, orderField);
        }
        logger.info("Found {} colleges on the order of {}", res.size(), orderField);
        MDC.clear();
        return res;
    }

    @GetMapping("/location")
    public List<College> findCollegeByLocation(HttpServletRequest req, @RequestParam("lon") Double lon, @RequestParam("lat") Double lat, @RequestParam("radius") Double radius ) {
        MDC.put("userInfo","User Id-" + req.getAttribute("userId"));
        logger.info(req.getRequestURI() + ": User is trying to find colleges at lon = {}, lat = {}, within = {}", lon, lat, radius * 1000);
        List<College> res =  collegeDao.findCollegeByLocation(lon, lat, radius);
        logger.info("Found {} colleges by the location ({},{}) within {}", res.size(), lon, lat, radius);
        MDC.clear();
        return res;
    }


//    @GetMapping("/FilteredCollege")
//    public List<College>  getFilteredCollegeInfo(@RequestParam String state, @RequestParam String control, @RequestParam String sat_verbal, @RequestParam String sat_math, @RequestParam String expenses) {
//        int verbal = Integer.parseInt( sat_verbal);
//        int math = Integer.parseInt( sat_math);
//        int cost = Integer.parseInt( expenses);
//        System.out.println("look up for " + state);
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
//        return  null;
//    }


}
