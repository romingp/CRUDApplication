package crudApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudApp.entities.Student;
import crudApp.repositories.StudentRepository;

@Service
public class StudentServiceImplimentation implements StudentService {
	@Autowired
	StudentRepository repo;
	@Override
	public String addStudent(Student s) {
		repo.save(s);
		return "Student added Successfully";
	}

	@Override
	public Student fetchStudent(String kodId) {
		return repo.findByKodId(kodId);
	}

	@Override
	public String updateStudent(Student s) {
		repo.save(s);
		return "Student updated Successfully";
	}

	@Override
	public String deleteStudent(String kodId) {
		repo.deleteById(kodId);
		return "Student deleted Successfully";
	}

}
