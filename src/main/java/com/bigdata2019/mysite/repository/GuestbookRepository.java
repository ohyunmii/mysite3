package com.bigdata2019.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigdata2019.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {

	@Autowired
	private SqlSession sqlSession;

	
	public Boolean insert(GuestbookVo vo) {
		 int count =sqlSession.insert("guestbook.insert", vo);
		 return(count==1);
	}

	public Boolean delete(Long no, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		int count = sqlSession.delete("guestbook.delete", map);
		return (count==1);
	}

	public List<GuestbookVo> findAll() {
		return sqlSession.selectList("guestbook.findAll");
	}


}
