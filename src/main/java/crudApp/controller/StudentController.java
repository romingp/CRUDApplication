package crudApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import crudApp.entities.Student;
import crudApp.services.StudentService;

@Controller
@RequestMapping("/crud")
public class StudentController {

		@Autowired
		StudentService service;
		
		@PostMapping("/create")
		public String create(@ModelAttribute Student s) {
			System.out.println(s);
			service.addStudent(s);
			return "index";
		}
		
		@GetMapping("/read")
		public String read(@RequestParam("kodId") String kodId, Model m){
			Student s=service.fetchStudent(kodId);
			m.addAttribute("s",s);
			return "showStudent";
		}
		
		@PutMapping("/update")
		public String update(@ModelAttribute Student s) {  
			service.updateStudent(s);
			return "index";
		}
		
		@DeleteMapping("/delete")
		public String delete(@RequestParam("kodId")String kodId) {
			service.deleteStudent(kodId);
			return "index";
		}	
}
