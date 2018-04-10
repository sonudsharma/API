package com.service;

import java.util.List;
import java.util.Map;

import com.models.FileInfo;
import com.models.Hospital;
import com.models.Users;

public interface UserService {

	long save(Users user);

	Users get(long id);

	Boolean authenticate(String username, String password);

	// List<Users> list();

	// void updateUser(Integer id, Users user);

	void updateToken(Integer id, String token);

	void delete(Integer UserId);

	Users fetchUser(String username, String password, String pin);

	Integer userRegistration(Users users);

	Users fetchUserByEmail(String email);

	Object updateProfile(Users user);

	Map<String, Object> resetPassword(Map<String, String> userMap);

	List<Map> getDoctorList(String string);

	Hospital getHospital(Long id);

	Users getPerson(Integer id);

	Object getupload(FileInfo fileInfo);

}
