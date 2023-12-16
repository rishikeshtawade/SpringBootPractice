package com.example.demo.Entity;


import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Student")
@EntityListeners(AuditingEntityListener.class)
public class StudentEntity {
	
	@Id
	private int idStudent;
	
	@NotNull
	@Size(min = 2, max = 30,message = "Enter Name of length between 2 to 30 !")
	private String fname;
	
	@NotNull
	@Size(min = 2, max = 30,message = "Enter Name of length between 2 to 30 ! ")
	private String lname;
	
	@NotBlank
    private String username;
	
	@Email(message = "Invalid Email format")
	private String email;
	
	@Min(value = 18, message = "Age must be at least 18")
	@Max(value = 100, message = "Age must not exceed 100")
	private int age;
	
//	@Size(min = 2, max = 10, message = "address must be between 2 and 20 characters")
//	private String address;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
	private String phone_number;
	
	 @CreatedDate
	 private LocalDateTime createdAt;

	 @LastModifiedDate
	 private LocalDateTime updatedAt;

	 @CreatedBy
	 private String createdBy;

	 @LastModifiedBy
	 private String updatedBy;
	
	@Embedded
	private Subject subject;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
}
