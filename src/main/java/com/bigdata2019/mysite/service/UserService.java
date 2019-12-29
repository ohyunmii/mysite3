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
	
	
	public UserVo getUser(String email, String password) {
		UserVo userVo = userRepository.find(email, password);
		return userVo;
	}


	public UserVo getUser(Long no) {
		UserVo userVo = userRepository.find(no);
		return userVo;
	}


	public Boolean update(Long no, String name, String password, String gender) {
		Boolean result = false;
		UserVo vo = new UserVo();
		vo.setNo(no);
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		UserVo userVo = userRepository.find(no);
		if(userVo.getNo().equals(vo.getNo())){
			result = userRepository.update(vo);
		}
		return result;
	}
}
