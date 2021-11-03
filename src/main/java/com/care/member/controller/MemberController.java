package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;

	@RequestMapping("index")
	public String index() {
		return "member/index";
	}

	@GetMapping("list")
	public String list(Model model) {
		ms.list(model);
		return "member/list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "member/insert";
	}

	@PostMapping("insert")
	public String postInsert(MemberDTO dto,HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		dto.setId(id);dto.setPwd(pwd);dto.setName(name);
		ms.insert(dto);
		return "member/index";
	}
	
	
}
