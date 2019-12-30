package com.bigdata2019.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata2019.mysite.repository.UserRepository;
import com.bigdata2019.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void join(UserVo vo) {
		userRepository.insert(vo);
	}

	public UserVo getUser(UserVo vo) {
		UserVo userVo = userRepository.find(vo);
		return userVo;
	}

	public UserVo getUser(Long no) {
		UserVo userVo = userRepository.find(no);
		return userVo;
	}

	public Boolean update(UserVo vo) {
		Boolean result = userRepository.update(vo);
		return result;
	}
}
