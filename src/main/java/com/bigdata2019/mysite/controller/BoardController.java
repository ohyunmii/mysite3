package com.bigdata2019.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigdata2019.mysite.service.BoardService;
import com.bigdata2019.mysite.vo.BoardVo;
import com.bigdata2019.mysite.vo.UserVo;
import com.bigdata2019.security.Auth;
import com.bigdata2019.security.AuthUser;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping({ "", "/list" })
	public String list(Model model, HttpSession session) {
		List<BoardVo> list = boardService.list();
		model.addAttribute("list", list);

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		model.addAttribute("authUser", authUser);
		
		return "board/list";
	}

	@Auth
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {

		return "/board/write";
	}

	@Auth
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@AuthUser UserVo authUser, BoardVo vo) {
		
		boardService.add(vo, authUser);

		return "redirect:/board/list";
	}

	// delete recycle bin png file invisible...
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "no", required = true, defaultValue = "") Long no) {
		boardService.delete(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(
			@RequestParam(value="keyword", required=true, defaultValue="")String keyword, 
			Model model) {
		List<BoardVo> list = boardService.search(keyword);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/view")
	public String view(
			@RequestParam(value = "no", required = true, defaultValue = "") Long no,
			Model model) {

		BoardVo boardVo = boardService.view(no);
		
		model.addAttribute("boardVo", boardVo);
		
		return "/board/view";
	}
	
	
	

}
