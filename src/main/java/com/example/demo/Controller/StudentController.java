package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Servicee.*;

import jakarta.transaction.Transactional;

@RestController
public class StudentController {
	
	@Autowired
	Service1 se;
	
	@GetMapping("listStudent")
	public ResponseEntity<StudentEntity> getStudentList()
	{
		return new ResponseEntity(se.getStudent(),HttpStatus.OK);
	}
	
	@GetMapping("getStudentById/{id}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable int id)
	{
		return new ResponseEntity(se.getStudentById(id),HttpStatus.OK);
	}

	@PostMapping("saveStudent")
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity studentEntity)
	{
		return new ResponseEntity(se.saveStudent(studentEntity),HttpStatus.CREATED);
	}
	
	@PostMapping("saveListStudent")
	public ResponseEntity<List<StudentEntity>> saveStudent(@RequestBody List<StudentEntity> listStudentEntity)
	{
		List<StudentEntity> lst=se.saveListStudent(listStudentEntity);
		return new ResponseEntity(lst,HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteStudentById/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int id)
	{
		 if (se.existsById(id)) {
	            se.deleteById(id);
	            return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
	        } else {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student id : "+id+" not found !");
	        }
	}
	
	@GetMapping("getStudentFirstById/{id}")
	public ResponseEntity<String> getStudentFirstById(@PathVariable int id)
	{
		String first=se.getStudentFirstById(id);
		return new ResponseEntity(first,HttpStatus.OK);
	}
	
	@GetMapping("getStudentFirstByName/{Name}")
	public ResponseEntity<List<StudentEntity>> getStudentFirstByName(@PathVariable("Name") String fname)
	{
		System.out.println(fname);
		return new ResponseEntity(se.getStudentFirstByName(fname),HttpStatus.OK);
	}
	
	@GetMapping("getStudentFirstByFNameAndLName/{fName}/{lName}")
	public ResponseEntity<List<StudentEntity>> getStudentEntityByFNameAndLName(@PathVariable("fName") String fnamee,@PathVariable("lName") String lnamee)
	{
		return new ResponseEntity<>(se.getStudentFirstByName(fnamee,lnamee),HttpStatus.OK);
	}
	
	@GetMapping("getStudentEntityByString/{str}")
	public ResponseEntity<List<StudentEntity>> getStudentEntityByFNameAndLName(@PathVariable("str") String str)
	{
		return new ResponseEntity<>(se.getStudentByString(str),HttpStatus.OK);
	}
	
	@GetMapping("count")
	public long getCount()
	{
		return se.getCount();
	}
	
	@Transactional
	@PostMapping("/updateUserName/{id}/{name}")
	public ResponseEntity<StudentEntity> updateUsername(@PathVariable("id") int id,@PathVariable("name") String unm)
	{
		StudentEntity sr=se.getStudentById(id);
		sr.setUsername(unm);
		return new ResponseEntity(sr, HttpStatus.OK);
	}
}
