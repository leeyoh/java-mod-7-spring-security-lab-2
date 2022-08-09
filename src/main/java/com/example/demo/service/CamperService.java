package com.example.demo.service;

import com.example.demo.dto.CamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Date;
import java.util.List;

@Service
public class CamperService {
    @Autowired
    CamperRepository camperRepository;
    @Autowired
    private ModelMapper mapper;
    public CamperDTO createCamper(CamperDTO camperDTO){
        Camper camper = mapper.map(camperDTO, Camper.class);
        camper.setUpdated_at(new Date());
        try{
            camper = camperRepository.save(camper);
        } catch( Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"validation errors",e);
        }
        return mapper.map(camper, CamperDTO.class);
    }

    public List<CamperDTO> getCampers(){
        return camperRepository.findAll().stream().map(
                camper -> mapper.map(camper, CamperDTO.class)
        ).toList();
    }

    public CamperDTO getCamper(Long id){
        Camper camper = camperRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Camper Not Found"));
        return mapper.map(camper, CamperDTO.class);
    }
}
