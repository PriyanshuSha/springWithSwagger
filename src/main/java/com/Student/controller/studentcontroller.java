package com.Student.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Student.DTO.StudentDTO;
import com.Student.exception.GlobalException;
import com.Student.model.Student;
import com.Student.service.StudentService;

@RestController
@RequestMapping("/student")
public class studentcontroller {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody @Valid StudentDTO s1){
	
		return new ResponseEntity<>(service.addStudent(s1),HttpStatus.OK);
		
	}
  
	@GetMapping("/retrive")
	public ResponseEntity<List<Student>> getStudent(){
		
		return new ResponseEntity<>(service.getStudent(),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) throws GlobalException {
			
			return new ResponseEntity<>(service.deleteStudent(id),HttpStatus.ACCEPTED);
		
		}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody @Valid StudentDTO s1){
	
		return new ResponseEntity<>(service.addStudent(s1),HttpStatus.OK);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) throws GlobalException{
		return new ResponseEntity<>(service.getStudent(id),HttpStatus.OK);
	}
	
	
}
