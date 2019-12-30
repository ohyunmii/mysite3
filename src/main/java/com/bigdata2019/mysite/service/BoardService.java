package com.bigdata2019.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata2019.mysite.repository.BoardRepository;
import com.bigdata2019.mysite.vo.BoardVo;
import com.bigdata2019.mysite.vo.UserVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public List<BoardVo> list(){
		List<BoardVo> entryList = boardRepository.findAll();
		return entryList;
	}
	
	public Boolean add(BoardVo bVo, UserVo uVo){
		Boolean result = boardRepository.insert(bVo, uVo);
		return result;
	}
	
	public Boolean delete(Long no) {
		Boolean result = boardRepository.delete(no);
		return result;
	}
	
	public List<BoardVo> search(String keyword){
		List<BoardVo> searchList = boardRepository.search(keyword);
		return searchList;
	}
	
	public BoardVo view(Long no) {
		BoardVo result = boardRepository.viewEntry(no);
		return result;
	}
	


}
