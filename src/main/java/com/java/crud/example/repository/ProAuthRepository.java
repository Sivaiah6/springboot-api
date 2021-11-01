package com.java.crud.example.repository;

import com.java.crud.example.entity.ProAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProAuthRepository extends JpaRepository<ProAuth,Integer> {
    ProAuth findByName(String name);
  //  public AddUserResponse addUsers(ProAuth proAuth);
}



