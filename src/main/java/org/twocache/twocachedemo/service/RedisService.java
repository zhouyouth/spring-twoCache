package org.twocache.twocachedemo.service;

import org.twocache.twocachedemo.bean.Person;

import java.util.List;

/**
 * 测试缓存
 * @author binghe
 *
 */
public interface RedisService {
	
	String getRedidInfo(String key, String defaultValue);

	String getInfo(String info);

	List<Person> getPersons();
}
