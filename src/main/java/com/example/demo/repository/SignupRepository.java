package com.example.demo.repository;
import com.example.demo.model.Camper;
import com.example.demo.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<Signup,Long> {}
