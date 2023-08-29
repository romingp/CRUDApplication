package crudApp.services;

import crudApp.entities.Student;

public interface StudentService{
	String addStudent(Student s);
	Student fetchStudent(String kodId);
	String updateStudent(Student s);
	String deleteStudent(String kodId);
}
