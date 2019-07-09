package com.bw.Service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import aj.org.objectweb.asm.Type;

import com.bw.Dao.UserDao;
import com.bw.Utils.ResultUtil;
import com.bw.entity.Shop;
import com.bw.entity.User;

@Service
public class UserServiceimp implements UserService {
	
	@Resource
	private UserDao dao;
	
	@Override
	public ResultUtil login(User user, HttpSession session) {
		
		ResultUtil r=new ResultUtil();
		
		User u=dao.login(user.getUname());
		
		if(u !=null){
			if(u.getUpwd().equals(user.getUpwd())){
				r.setStatus(0);
				r.setMsg("��¼�ɹ�");
				session.setAttribute("user", u);
				return r;
			}else{
				r.setStatus(1);
				r.setMsg("����������������������");
				return r;
			}
		}else{
			r.setStatus(2);
			r.setMsg("�û���������������������");
			return r;
		}
	}

	@Override
	public List<Shop> findAll(String sname, String minprice, String maxprice) {
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		
		map.put("sname", sname);
		map.put("minprice", minprice);
		map.put("maxprice", maxprice);
		
		return dao.findAll(map);
	}

	@Override
	public int deleteAll(String sid) {
		// TODO Auto-generated method stub
		return dao.deleteAll(sid);
	}

	@Override
	public List<Type> findType() {
		// TODO Auto-generated method stub
		return dao.findType();
	}

	@Override
	public int addOne(Shop shop) {
		// TODO Auto-generated method stub
		return dao.addOne(shop);
	}

}
