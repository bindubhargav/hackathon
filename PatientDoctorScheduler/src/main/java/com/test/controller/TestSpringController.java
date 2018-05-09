package com.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dto.RequestDTO;
import com.test.dto.ResponseDTO;
import com.test.dto.User;
import com.test.service.DoctorRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TestSpringController {
	
	@Autowired
	private ResponseDTO responseDTO;
	
    @Autowired
    private DoctorRepository userRepository;

	@RequestMapping(value = "/api/name/{firstname}", method = RequestMethod.POST, produces = "application/json")
    public ResponseDTO index(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("firstname") String firstname,
			@RequestBody RequestDTO requestDTO) throws JsonProcessingException 
	{
		String lastname = request.getHeader("lastname");

		String username = firstname+" "+lastname;
		User user = new User(username, 25);
//		userRepository.save(user);
//		System.out.println("UserId: "+user.getId());
//		
//		User userA = userRepository.findByName(username);
//		System.out.println("User retrieved: " +new ObjectMapper().writeValueAsString(userA));
//		
//		Iterable<User> users = userRepository.findAll();
//        int count = 0;
//        for(User p : users){
//            count++;
//        }
//        System.out.println("Count of Users: "+count);
		
		responseDTO.setFirstname(firstname);
		responseDTO.setLastname(lastname);
		responseDTO.setEmail(requestDTO.getEmail());
		
        return responseDTO;
    }

}