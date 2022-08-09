package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.service.ActivityService;
import com.example.demo.service.CamperService;
import com.example.demo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")

public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping
    public List<ActivityDTO> getActivities(){
        return activityService.getActivities();
    }

    @DeleteMapping("/{id}")
    public ActivityDTO deleteActivity(@PathVariable Long id){
        return activityService.deleteActivity(id);
    }
}
