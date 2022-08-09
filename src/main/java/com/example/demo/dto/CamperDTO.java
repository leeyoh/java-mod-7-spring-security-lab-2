package com.example.demo.dto;
import lombok.Data;

import java.util.Date;

@Data
public class CamperDTO {
    private long id;
    private String name;
    private int age;
    private Date updated_at;
}
