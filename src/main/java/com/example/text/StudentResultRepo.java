package com.example.text;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResultRepo extends JpaRepository<StudentResultDataEntity,Integer> {
	@Query("SELECT COUNT(srd) FROM StudentResultDataEntity srd JOIN srd.Student sa WHERE sa.username = :username AND srd.subject = :examTopic")
    Long countByStudentAndSubject(String username, String examTopic);
	
	@Query("SELECT srd.subject, srd.marksObtained FROM StudentResultDataEntity srd JOIN srd.Student sa WHERE sa.username = :username")
	List<Object[]> findSubjectAndMarksByUsername(String username);



}
