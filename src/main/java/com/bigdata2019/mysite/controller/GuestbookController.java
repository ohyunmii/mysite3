package com.bigdata2019.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigdata2019.mysite.service.GuestbookService;
import com.bigdata2019.mysite.vo.GuestbookVo;
import com.bigdata2019.security.Auth;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	
	@RequestMapping({"", "/list"})
	public String index(Model model) {
		List<GuestbookVo> list = guestbookService.list();
		model.addAttribute("list", list);

		return "guestbook/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo vo) {
		guestbookService.add(vo);
		return "redirect:/guestbook/list";
	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/delete";
	}

	@RequestMapping( value="/delete", method=RequestMethod.POST )
	public String delete( @ModelAttribute GuestbookVo vo ){
		System.out.println(vo);
		guestbookService.delete( vo.getNo(), vo.getPassword() );
		return "redirect:/guestbook";
	}
	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String delete() {
//		return "guestbook/delete";
//	}
	
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String delete(
//			@RequestParam(value = "no", required = true, defaultValue = "0") Long no,
//			@RequestParam(value = "password", required = true, defaultValue = "0") String password,
//			Model model) {
//
//		Boolean result = guestbookService.delete(no, password);
//		model.addAttribute("result", result);
//		return "redirect:/guestbook/delete";
//	}

}