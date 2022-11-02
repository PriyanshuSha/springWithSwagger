package com.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Student.model.Student;

public interface studentRepository extends JpaRepository<Student,Integer> {

	@Query(value="select * from Student where Student_id=?1", nativeQuery=true)
	Student findByStudentId(int id);
	

}
