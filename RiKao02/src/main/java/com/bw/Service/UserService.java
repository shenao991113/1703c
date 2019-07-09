package com.bw.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import aj.org.objectweb.asm.Type;

import com.bw.Utils.ResultUtil;
import com.bw.entity.Shop;
import com.bw.entity.User;

public interface UserService {

	public ResultUtil login(User user, HttpSession session);

	public List<Shop> findAll(String sname, String minprice, String maxprice);

	public int deleteAll(String sid);

	public List<Type> findType();

	public int addOne(Shop shop);

}
