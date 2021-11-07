package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
//@RequestMapping("member")//이렇게 해주면 아래에 것들은 그냥 써도 됨 
public class MemberController {
	@Autowired
	MemberService ms;

	@GetMapping("index")
	public String index(HttpServletResponse response, Model model,
			@CookieValue(value = "myCookie", required = false) Cookie cook, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + " : " + c.getValue());
			}
		}
		System.out.println("cook: " + cook);
		if (cook != null) {
			model.addAttribute("cook", cook.getValue());
		}
		return "member/index";
	}

	@RequestMapping("cookieChk")
	public void cookieChk(HttpServletResponse response) {
		Cookie cook = new Cookie("myCookie", "쿠키");
		cook.setMaxAge(1000);
		cook.setPath("/");// <---이건 뭐지(없으면 쿠키가 안만들어짐)
		response.addCookie(cook);
	}

	@RequestMapping("popup")
	public String popup() {
		return "member/popup";
	}

	@RequestMapping("/success")
	public String postIndex(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("id", request.getParameter("id"));
		String name = ms.selectName(request.getParameter("id"));
		session.setAttribute("name", name);
		ms.check(request.getParameter("id"), request.getParameter("pwd"), model);
		return "member/success";
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
	public String postInsert(MemberDTO dto, HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		ms.insert(dto);
		return "redirect:/index";
	}

	// 한방에 모든 값을 넣어줄수도 있음
	// 전에 했던 jsp:setproperties var="dao" value="*" 했던 것처럼
	@PostMapping("insert2")
	public String postInsert2(MemberDTO dto) {
		ms.insert(dto);
		return "redirect:/index";
	}

	@RequestMapping("memberPage")
	public String memberPage(HttpServletRequest request, MemberDTO dto, Model model) {
		System.out.println("here");
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setName(request.getParameter("name"));
		model.addAttribute("member", dto);
		return "member/memberPage";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
}
