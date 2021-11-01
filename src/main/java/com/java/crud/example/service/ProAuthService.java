package com.java.crud.example.service;

import com.java.crud.example.repository.ProAuthRepository;
import com.java.crud.example.entity.ProAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProAuthService {
    @Autowired
    private ProAuthRepository repository;

    public ProAuth saveMember(ProAuth member) {
        return repository.save(member);
    }

    public List<ProAuth> saveMembers(List<ProAuth> members) {
        return repository.saveAll(members);
    }

    public List<ProAuth> getMembers() {
        return repository.findAll();
    }

    public ProAuth getMemberById(int id) {
        return repository.findById(id).orElse(null);
    }

    public ProAuth getMemberByName(String name) {
        return repository.findByName(name);
    }

    public String deleteMember(int id) {
        repository.deleteById(id);
        return "Member removed !! " + id;
    }

    public ProAuth updateMember(ProAuth member) {
        ProAuth existingMember = repository.findById(member.getMemberId()).orElse(null);
        existingMember.setName(member.getName());
       // existingMember.setQuantity(member.getQuantity());
        //existingMember.setPrice(member.getPrice());
        return repository.save(existingMember);
    }


}
