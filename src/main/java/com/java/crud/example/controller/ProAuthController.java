package com.java.crud.example.controller;

import com.java.crud.example.service.ProAuthService;
import com.java.crud.example.entity.Member.ProAuth;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProAuthController {

    @Autowired
    private ProAuthService service;

    public ProAuthController(ProAuthService proAuthService) {
    }

    @PostMapping("/addMember")
    @ApiOperation(value = "Save a Member")
    public ProAuth addMember(@Valid @RequestBody ProAuth member) {
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
    @ApiOperation(value = "Save multiple Members",
            notes = "Also returns a link to retrieve all members with rel - all-members")
    public List<ProAuth> addMembers(@RequestBody List<ProAuth> members) {
        return service.saveMembers(members);
    }

    @GetMapping("/members")
    @ApiOperation(value = "Find All Members",
            notes = "Also returns a link to retrieve all members with rel - all-members")
    public   List<ProAuth> findAllMembers() {

        return service.getMembers();

    }

    @GetMapping("/memberById/{id}")
    @ApiOperation(value = "Find member by id",
            notes = "Also returns a link to retrieve all members with rel - all-members")
    public ProAuth findMemberById(@PathVariable int id) {
        return service.getMemberById(id);
    }

    @GetMapping("/member/{name}")
    @ApiOperation(value = "Find member by name",
            notes = "Also returns a link to retrieve all members with rel - all-members")
    public ProAuth findMemberByName(@PathVariable String name) {
        return service.getMemberByName(name);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update a Member Details")
    public ProAuth updateMember(@RequestBody ProAuth member) {
        return service.updateMember(member);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete member by id")
    public String deleteMember(@RequestParam("id") int id) {
        return service.deleteMember(id);
    }
}
