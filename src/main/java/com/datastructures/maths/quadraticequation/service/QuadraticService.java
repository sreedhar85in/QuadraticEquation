package com.datastructures.maths.quadraticequation.service;

import org.springframework.stereotype.Service;

import com.datastructures.maths.quadraticequation.exception.InternalException;
import com.datastructures.maths.quadraticequation.model.QuadraticrootResponse;

@Service
public class QuadraticService {

	public QuadraticrootResponse findroots(double a, double b, double c) throws InternalException {
		double root1 = 0;
		double root2 = 0;
		
		if (a==0) {
			
			throw new InternalException(400, "a cannot be zero since equaltion will become linear", "quadratic equation a should not be 0");
		}
		
		
		double discriminant = b*b - 4*a*c;
		double squarerootval = Math.sqrt(Math.abs(discriminant));
		
		if (discriminant>=0) {
			
			 root1 = (-b + squarerootval)/(2*a);
			 root2 = (-b- squarerootval)/(2*a);
		}
		//formula
		
		if(discriminant<0) {
			
			throw new InternalException(400, "no real roots, its imaginary", "imgainary roots are present for this equation");
		}
		
		StringBuilder test = new StringBuilder();
		test.append("The first root is"  + root1 + " " + "and the second root is, " + " " + root2);
		
		// -b+-root bsquare-4ac/2a
		
		// TODO Auto-generated method stub
		
		QuadraticrootResponse response = new QuadraticrootResponse();
		response.setOutcomeCode(200);
		response.setOutcomeMessage("Success");
		response.setRootsoftheequation(test);
		return response;
	}

}
