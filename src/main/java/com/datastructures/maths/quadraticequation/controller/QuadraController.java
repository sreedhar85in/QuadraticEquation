package com.datastructures.maths.quadraticequation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructures.maths.quadraticequation.exception.InternalException;
import com.datastructures.maths.quadraticequation.model.QuadraticrootReq;
import com.datastructures.maths.quadraticequation.model.QuadraticrootResponse;
import com.datastructures.maths.quadraticequation.service.QuadraticService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Quadratic")
public class QuadraController {
	
	@Autowired
	QuadraticService quadraticService;
	
	@ApiOperation(value = "Program to find the roots of a quadratic equation", notes = "Root finding program")
	@PostMapping("/findroots")
	public ResponseEntity findroots(HttpServletRequest req1, @RequestBody QuadraticrootReq req) throws InternalException {
		
		String token = req1.getHeader("Authorization");
		System.out.println("token is" + token);
		
		QuadraticrootResponse response = quadraticService.findroots(req.getA(),req.getB(),req.getC());
		
		return new ResponseEntity(response,HttpStatus.OK);
		
		
		
	}

}
