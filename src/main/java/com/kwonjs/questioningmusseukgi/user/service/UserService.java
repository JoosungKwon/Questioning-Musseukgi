package com.kwonjs.questioningmusseukgi.user.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwonjs.questioningmusseukgi.user.model.User;
import com.kwonjs.questioningmusseukgi.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;

	public List<User> getByTime(LocalTime startTime, LocalTime finishTime) {
		return userRepository.searchUserByTime(startTime, finishTime);
	}
}

