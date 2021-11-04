package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberChk;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired MemberDAO dao;

	public void insert(MemberDTO dto) {
		dao.insert(dto);
	}

	public  void list(Model model) {
		model.addAttribute("list",dao.list());		
	}

	public void check(String id, String pwd, Model model) {
		MemberChk chk= dao.check(id,pwd,model);
		model.addAttribute("check",chk);
	}
	
}
