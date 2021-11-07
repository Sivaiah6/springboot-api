package com.java.crud.example.repository;

import com.java.crud.example.entity.Member.ProAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProAuthRepository extends JpaRepository<ProAuth,Integer> {
    ProAuth findByName(String name);
  //  public AddUserResponse addUsers(ProAuth proAuth);

    @Query(value = "CALL FIND_Member(:mem_id);", nativeQuery = true)
    List<ProAuth> findMem(@Param("mem_id") Integer mem_id);

    public static final String FIND_MEMBERS = "SELECT * FROM member";

    @Query(value = FIND_MEMBERS, nativeQuery = true)
    public List<Object[]> findProjects();
}



