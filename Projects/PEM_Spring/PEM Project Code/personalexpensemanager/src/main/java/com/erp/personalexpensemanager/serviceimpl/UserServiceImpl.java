package com.erp.personalexpensemanager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.personalexpensemanager.dao.PEMDao;
import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.User;
import com.erp.personalexpensemanager.service.PEMService;

@Service("userservice")
public class UserServiceImpl implements PEMService {

	@Autowired
	private PEMDao userdao;
	
	public PEMDao getUserdao() {
		return userdao;
	}


	public void setUserdao(PEMDao userdao) {
		this.userdao = userdao;
	}


	public int addUser(User user) throws CustomNullPointerException {
		
		return userdao.addUser(user);
	}
	
	public User loginUser(String username) throws CustomNullPointerException {
		
		return userdao.loginUser(username);
	}
}
