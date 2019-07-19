package com.shenao.cms.service;

import com.shenao.cms.domain.Settings;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月28日 上午11:11:37
 */
public interface SettingsService {

	public abstract void save(Settings settings);

	public abstract void update(Settings settings);

	public abstract Settings get();

}