/**
 * 
 */
package com.shenao.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shenao.cms.dao.SlideMapper;
import com.shenao.cms.domain.Slide;
import com.shenao.cms.service.SlideService;

/**
 * 说明:频道与分类服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:25:35
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class SlideServiceImpl implements SlideService {

	@Resource
	private SlideMapper slideMapper;

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#save(com.bawei.cms.domain.Slide)
	 */
	@Override
	@Transactional
	public void save(Slide slide) {
		slide.setCreated(new Date());
		slideMapper.insert(slide);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#updateByKey(com.bawei.cms.domain.Slide)
	 */
	@Override
	@Transactional
	public void update(Slide slide) {
		slideMapper.updateByKey(slide);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#deleteById(int)
	 */
	@Override
	@Transactional
	public void remove(int id){
		slideMapper.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#selectById(int)
	 */
	@Override
	public Slide get(int id){
		return slideMapper.selectById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#selectTop(int)
	 */
	@Override
	public List<Slide> getTops(int size){
		return slideMapper.selectTop(size);
	}

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#selectAll()
	 */
	@Override
	public List<Slide> getAall(){
		return slideMapper.selectAll();
	}
	
}
