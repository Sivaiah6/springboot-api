package com.java.crud.example.controller;

import com.java.crud.example.service.ProAuthService;
import com.java.crud.example.entity.ProAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProAuthController {

    @Autowired
    private ProAuthService service;

    @PostMapping("/addMember")
    public ProAuth addMember(@RequestBody ProAuth member) {
        return service.saveMember(member);
    }

    /*@PostMapping("/addUsers")
    public ResponseEntity<Object> addUser(@Valid @RequestBody ProAuth addUserRequest,
                                          HttpServletRequest httpServletRequest) throws Exception {
      //  AddUserResponse addUserResponse = new AddUserResponse(Constant.STATUS_TRUE, Constant.SUCCESS);
        addUserResponse = service.addUsers(addUserRequest);
        return ResponseEntity.ok(addUserResponse);
    }*/

    @PostMapping("/addMembers")
    public List<ProAuth> addMembers(@RequestBody List<ProAuth> members) {
        return service.saveMembers(members);
    }

    @GetMapping("/members")
    public   List<ProAuth> findAllMembers() {

        return service.getMembers();

    }

    @GetMapping("/memberById/{id}")
    public ProAuth findMemberById(@PathVariable int id) {
        return service.getMemberById(id);
    }

    @GetMapping("/member/{name}")
    public ProAuth findMemberByName(@PathVariable String name) {
        return service.getMemberByName(name);
    }

    @PutMapping("/update")
    public ProAuth updateMember(@RequestBody ProAuth member) {
        return service.updateMember(member);
    }

    @PostMapping("/delete")
    public String deleteMember(@RequestParam("id") int id) {
        return service.deleteMember(id);
    }
}
