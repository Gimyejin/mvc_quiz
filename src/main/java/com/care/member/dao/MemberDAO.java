package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.care.member.dto.MemberChk;
import com.care.member.dto.MemberDTO;
@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	
	public MemberDAO() {
		list=new ArrayList<MemberDTO>();
	}
	public void insert(MemberDTO dto) {
		list.add(dto);
	}
	public ArrayList<MemberDTO> list() {
		return list;
	}
	public MemberChk check(String id, String pwd, Model model) {
		MemberChk chk = new MemberChk();
		if(list.size() != 0) {
			for(MemberDTO member : list) {
				if(id.equals(member.getId())) {
					if(pwd.equals(member.getPwd())) {
						chk.setChk(1);//로그인 성공
						chk.setName(member.getName());
						return chk;
					}
					else chk.setChk(0);//pw불일치
				}
				else chk.setChk(-1);//아이디 불일치
			}
		}
		return chk;
	}
}
