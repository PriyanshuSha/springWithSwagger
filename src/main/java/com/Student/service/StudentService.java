package com.Student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Student.DTO.StudentDTO;
import com.Student.exception.GlobalException;
import com.Student.model.Student;
import com.Student.repository.studentRepository;

@Service
public class StudentService {
	
	@Autowired
	private studentRepository sturepo;	
	
	public Student addStudent(StudentDTO s1) {
		Student s2=Student.build(s1.getStudentId(),s1.getStudentName(),s1.getStudentPhone(),s1.getStudentEmail(),s1.getStudentPassword());
		return sturepo.save(s2);
		
	}

	public List<Student> getStudent(){
		return sturepo.findAll();
	}
	
	
	public Student deleteStudent(int id) throws GlobalException  {
	
		Student _s2=sturepo.findByStudentId(id);
		if(_s2!=null) {
			sturepo.deleteById(id);
			return _s2;
		}
		else {
			throw new GlobalException("Student not found please enter correct id ");
		}
		
	}
	
	
	public Student updateStudent(StudentDTO s1) {
		
		Student s2=Student.build(s1.getStudentId(),s1.getStudentName(),s1.getStudentPhone(),s1.getStudentEmail(),s1.getStudentPassword());
		return sturepo.save(s2);
	}
	
	
	
	public Student getStudent(int Studentid) throws GlobalException
	{
		Student _s1=sturepo.findByStudentId(Studentid);
		if(_s1!=null) {
			return _s1;
		}
		else {
			throw new GlobalException("Student not found of this studentid "+Studentid);
		}
	}
	
	
}
