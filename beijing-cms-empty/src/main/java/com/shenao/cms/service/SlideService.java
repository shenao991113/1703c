package com.shenao.cms.service;

import java.util.List;

import com.shenao.cms.domain.Slide;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月28日 下午4:48:47
 */
public interface SlideService {

	public abstract void save(Slide slide);

	public abstract void update(Slide slide);

	public abstract void remove(int id);

	public abstract Slide get(int id);

	public abstract List<Slide> getTops(int size);

	public abstract List<Slide> getAall();

}