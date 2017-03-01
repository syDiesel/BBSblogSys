/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.PersonalInfo;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface PersonalInfoService {

	public void savePersonalInfo(PersonalInfo per);

	public void updatePersonalInfo(PersonalInfo per);

	public void deletePersonalInfo(long id);

	public List<PersonalInfo> listPersonalInfo();
	
	public PersonalInfo findById(long id);
}
