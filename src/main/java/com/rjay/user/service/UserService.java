package com.rjay.user.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rjay.user.entity.User;
import com.rjay.user.repository.UserRepository;
import com.rjay.user.valueObject.Department;
import com.rjay.user.valueObject.ResponseTemplateVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public ResponseTemplateVO getUserWithDepartment(Long userId) throws URISyntaxException {
		
		//log.info
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		URI uri = new URI("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId());
		System.out.println(uri);
		
		Department department = restTemplate.getForObject( uri , Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}

}
