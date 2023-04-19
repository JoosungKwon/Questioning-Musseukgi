package com.kwonjs.questioningmusseukgi.user.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kwonjs.questioningmusseukgi.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//TODO: 11시 - (0시)12시로 넘어갈 때 문제가 생김 추후에 리팩터링 필요
	@Query(value = """
			SELECT u
			FROM User u
			WHERE u.notificationTime BETWEEN :startTime AND :finishTime
			""")
	List<User> searchUserByTime(@Param("startTime") LocalTime startTime, @Param("finishTime") LocalTime finishTime);
}
