package com.example.demo.service;

import com.example.demo.dto.ActivityDTO;
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

@Service

public class SignupService {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    SignupRepository signupRepository;

    @Autowired
    CamperRepository camperRepository;

    @Autowired
    private ModelMapper mapper;

    /**
     * Checks to see if the camper id and activity are valid
     * if they are not valid return an "invalid error"
     * Else
     * Update the Signup Activity and Camper sets
     */
    public ActivityDTO createSignup(CreateSignupDTO signupDTO){
        Activity activity = activityRepository.findById(signupDTO.getActivity_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"validation errors"));
        Camper camper = camperRepository.findById(signupDTO.getCamper_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"validation errors"));
        Signup signup = mapper.map(signupDTO, Signup.class);
        camper.getSignupSet().add(signup);
        activity.getSignupSet().add(signup);
        signup.setActivity(activity);
        signup.setCamper(camper);
        camper.setUpdated_at(new Date());
        activity.setUpdated_at(new Date());
        signup.setUpdated_at(new Date());

        signupRepository.save(signup);
        camperRepository.save(camper);
        activityRepository.save(activity);

        return mapper.map(activity,ActivityDTO.class);
    }

}
