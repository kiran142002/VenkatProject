package com.studentapi.kiran;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/")
	public List<StudentModel> GetAll()
	{
		 List<StudentModel> list=repo.all_student();
		 return list;
	}
	
	
	@PostMapping("/post")
	public void Insert_Students(@RequestBody StudentModel std) {
		if(std!=null) {
			repo.sp_insert(std.getEmail(), std.getPassword(), std.getName(), std.getCourse(), std.getFees());
		}
	
	}

}
