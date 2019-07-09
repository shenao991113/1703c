package com.bw.Dao;

import java.util.HashMap;
import java.util.List;

import aj.org.objectweb.asm.Type;

import com.bw.entity.Shop;
import com.bw.entity.User;

public interface UserDao {

	public User login(String uname);

	public List<Shop> findAll(HashMap<String, Object> map);

	public int deleteAll(String sid);

	public List<Type> findType();

	public int addOne(Shop shop);

}
