package com.bigdata2019.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata2019.mysite.repository.GuestbookRepository;
import com.bigdata2019.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookRepository guestbookRepository;

	public void add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}

	public List<GuestbookVo> list() {
		List<GuestbookVo> guestbookList = guestbookRepository.findAll();
		return guestbookList;
	}
	
	public Boolean delete(Long no, String password) {
		Boolean result = guestbookRepository.delete(no, password);
		return result;
	}

}
