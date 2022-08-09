package com.example.demo.service;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateSignupDTO;
import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.model.Signup;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.CamperRepository;
import com.example.demo.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    private ModelMapper mapper;

    public List<ActivityDTO> getActivities(){
        return activityRepository.findAll().stream().map(
                activity -> mapper.map(activity, ActivityDTO.class)
        ).toList();
    }

    public ActivityDTO deleteActivity(Long id){

//        activityRepository.deleteById(id);
//        throw new ResponseStatusException(HttpStatus.ACCEPTED,"Removed " + id);
        Optional<Activity> activityOptional = activityRepository.findById(id);
        Activity activity = activityOptional.orElseThrow(()->new Error("Activity not found"));
        activityRepository.delete(activity);
        return mapper.map(activity,ActivityDTO.class);

    }
}
