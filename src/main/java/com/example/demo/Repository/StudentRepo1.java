package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import com.example.demo.Entity.StudentEntity;

public interface StudentRepo1 extends JpaRepository<StudentEntity, Integer> 
{
	@Query("select fname from StudentEntity s where s.idStudent=id")
	public String getFirstName(@Param("id") int id);

	List<StudentEntity> findByFnameIgnoreCase(String fname);

	List<StudentEntity> findByFnameAndLname(String fname, String lname);
	
	List<StudentEntity> findByFnameContaining(String partialName);
	
//	@Query("select std.fname,count(address),std.city from Student std  where where std.fname=name Group By std.idStudent")
//	StudentEntity findAddressCount(String name);
		
}
