package com.example.text;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentAuth, Long> {

	StudentAuth findByUsername(String username);
	@Query("SELECT s.studentID FROM StudentAuth s WHERE s.username = :username")
	Integer findIDByUsername(String username);
	
}
