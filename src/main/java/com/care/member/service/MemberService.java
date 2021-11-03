package com.care.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired MemberDAO dao;

	public void insert(MemberDTO dto) {
		dao.insert(dto);
	}

	public Model list(Model model) {
		return model.addAttribute("list",dao.list());		
	}
	
}
