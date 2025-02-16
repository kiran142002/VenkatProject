package com.studentapi.kiran;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;
import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer>{
	
	@Query(nativeQuery =true, value="all_student")
	public List<StudentModel>all_student();

	@Transactional
	@Modifying
	@Query(nativeQuery =true, value="sp_insert :email, :password, :name, :course, :fees")
	public List<StudentModel>sp_insert(@Param ("email") String email,@Param ("password")String password,@Param ("name")String name,@Param ("course")String course,@Param ("fees")int fees );
	

	
	

}
