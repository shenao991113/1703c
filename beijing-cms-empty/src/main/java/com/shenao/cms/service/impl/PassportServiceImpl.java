/**
 * 
 */
package com.shenao.cms.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.shenao.cms.domain.User;
import com.shenao.cms.metas.Gender;
import com.shenao.cms.service.PassportService;
import com.shenao.cms.utils.AssertUtil;
import com.shenao.cms.utils.Codings;

/**
 * 说明:注册登录服务，训练学生一个接口多个bean情况。
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午3:23:42
 */
@Service("passportService")
public class PassportServiceImpl extends UserServiceImpl implements PassportService {

	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.PassportService#reg(java.lang.String, java.lang.String, java.lang.String, com.bawei.cms.metas.Gender)
	 */
	@Override
	public User reg(String username, String password, String nickname, Gender gender){
		
		AssertUtil.hasLength(username, "用户名不能空");
		AssertUtil.hasLength(password, "密码不能空");
		
		//判断用户是否已注册
		int count = super.count(new User(username));
		AssertUtil.isTrue(count == 0, "用户名已占用，请更换");
		
		User user = new User();
		if(nickname == null){
			nickname = username;
		}
		user.setNickname(nickname);
		user.setUsername(username);
		
		//加密密码
		password = PassportService.encrypt(username, password);
		user.setPassword(password);
		
		user.setGender(gender);
		user.setLocked(false);
		user.setCreated(new Date());
		user.setUpdated(user.getCreated());
		userMapper.insert(user);
		
		User result = new User();
		BeanUtils.copyProperties(user, result, "password");
		return result;
	}
	
	/**
	 * 功能说明：登录<br>
	 * @param username
	 * @param password
	 * @return
	 * User
	 */
	public User login(String username, String password){
		
		AssertUtil.hasLength(username, "用户名不能空");
		AssertUtil.hasLength(password, "密码不能空");
		
		User user = userMapper.selectByUsername(username);
		AssertUtil.notNull(user, "用户名或密码错误");
		
		//加密密码
		password = Codings.MD5Encoding(password + SALT + username);
		AssertUtil.isTrue(password.equals(user.getPassword()), "密码错误");
		
		AssertUtil.isFalse(user.getLocked(), "用户被锁定，请联系管理员");
		
		User result = new User();
		BeanUtils.copyProperties(user, result, "password");
		return result;
	}
	
	
}
