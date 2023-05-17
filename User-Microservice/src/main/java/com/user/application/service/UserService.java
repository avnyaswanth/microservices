package com.user.application.service;

import com.user.application.dto.Department;
import com.user.application.dto.UserDetails;
import com.user.application.entity.Userr;
import com.user.application.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    private final String deptServiceUrl = "http://DEPT-SERVICE/dept/";

    public List<Userr> getUsers() {
        return userRepo.findAll();
    }

    public void addUser(Userr user) {
        log.warn("{}", user);
        userRepo.save(user);
    }

    public UserDetails getUserWithDept(int id) {
        Userr user = userRepo.findById(id).get();
        UserDetails details = new UserDetails();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Department> response = restTemplate.exchange(deptServiceUrl+user.getDeptid(), HttpMethod.GET, entity, Department.class);
        Department dept = response.getBody();
        details.setUser(user);
        details.setDepartment(dept);
        return details;
    }
}
