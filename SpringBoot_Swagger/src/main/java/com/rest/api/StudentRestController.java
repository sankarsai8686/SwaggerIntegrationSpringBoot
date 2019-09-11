package com.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.schema.Model;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	private Student student;
	
	@RequestMapping(method=RequestMethod.GET , value="/gettDetails")
	public Student getStudentDetails()
	{
		System.out.println("getStudentDetails called");
		student.setName("Sankar Sai");
		student.setAge(24);
		return student;
	}
	
	@ApiOperation(value = "Add Student",response = Student.class)
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public Student addStudent(@RequestBody Student student)
	{
		System.out.println("addStudent");
		//return "Name : "+student.getName()+" : Age : "+student.getAge();
		return student;
	}
	
    @ApiOperation(value = "Search a student",response = Student.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Student showDetails(@PathVariable Integer id, Model model){
    	System.out.println("showDetails id : "+id);
    	Student student = new Student();
    	student.setName("Sai");
        return student;

    }
	

}
