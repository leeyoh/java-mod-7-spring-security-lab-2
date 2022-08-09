package com.example.demo.controller;

import com.example.demo.dto.CamperDTO;
import com.example.demo.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    CamperService camperService;
    @PostMapping // localhost:8080/campers post
    public CamperDTO createCamper(@RequestBody CamperDTO camper){
        return camperService.createCamper(camper);
    }
    @GetMapping
    public List<CamperDTO> getCampers(){
        return camperService.getCampers();
    }
    @GetMapping("/{id}") //localhost:8080/campers/id
    public CamperDTO getCamper(@PathVariable Long id){
        return camperService.getCamper(id);
    }

}
