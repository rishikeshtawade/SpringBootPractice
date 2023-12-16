package com.example.demo.Servicee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepo1;

import jakarta.transaction.Transactional;

@Service
public class Service1 {
	
	@Autowired
	StudentRepo1 sr;
	
	public List<StudentEntity> getStudent() 
	{
		System.out.println(sr.findAll());
		List<StudentEntity> students = sr.findAll();

				for (StudentEntity student : students) {
				    System.out.println("ID: " + student.getFname());
				    System.out.println("Name: " + student.getEmail());
				    // Print other properties as needed
				}
		return sr.findAll();
	}

	public StudentEntity getStudentById(int id) 
	{
		Optional<StudentEntity> opt=sr.findById(id);
		StudentEntity se=opt.get();
		return se;
	}
	
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		StudentEntity studentEntityy=sr.save(studentEntity);
		return studentEntityy;
	}
	
	public List<StudentEntity> saveListStudent(List<StudentEntity> listStudentEntity) {
		List<StudentEntity> listStudentEntity1=sr.saveAll(listStudentEntity);
		return listStudentEntity1;
	}

	public boolean existsById(int id) {
		if(sr.existsById(id))
		{
			return true;
		}
		return false;
	}

	public void deleteById(int id) {
		sr.deleteById(id);
	}

	public String getStudentFirstById(int id) {
		System.out.println(sr.getFirstName(id));
		return sr.getFirstName(id);
	}

	public List<StudentEntity> getStudentFirstByName(String fname)
	{
		List<StudentEntity> l1=sr.findByFnameIgnoreCase(fname);
		for(StudentEntity st:l1) {System.out.println(st.getIdStudent());};
		return sr.findByFnameIgnoreCase(fname);
	}

	public List<StudentEntity> getStudentFirstByName(String fnamee,String lnamee) 
	{
		return sr.findByFnameAndLname(fnamee,lnamee);
	}

	public List<StudentEntity> getStudentByString(String str)
	{
		return sr.findByFnameContaining(str);
	}

	public long getCount() {
		return sr.count();
	}

}
