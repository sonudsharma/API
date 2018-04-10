package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.models.FileInfo;
import com.models.Hospital;
import com.models.Users;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Users user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			session.close();
		}

		return user.getId();
	}

	public void updateToken(Integer id, String token) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Users user = session.byId(Users.class).load(id);
			user.setToken(token);
			transaction.commit();

		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	/*
	 * @Override public void updateUser(Integer id, Users user) { Session
	 * session = sessionFactory.getCurrentSession(); Users user2 =
	 * session.byId(Users.class).load(id); user2.setToken(user.getToken()); //
	 * user2.setPassword(user.getPassword()); //
	 * user2.setUsername(user.getUsername()); //
	 * sessionFactory.getCurrentSession().saveOrUpdate(user); session.flush(); }
	 */

	@Override
	public Users get(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Users user = null;
		try {
			transaction = session.beginTransaction();
			user = session.get(Users.class, id);
			transaction.commit();
			return user;

		} catch (Exception e) {

		}
		return user;

		// return sessionFactory.getCurrentSession().get(Users.class, id);
	}

	/*
	 * @Override public List<Users> list() { Session session =
	 * sessionFactory.getCurrentSession(); CriteriaBuilder cb =
	 * session.getCriteriaBuilder(); CriteriaQuery<Users> cq =
	 * cb.createQuery(Users.class); Root<Users> root = cq.from(Users.class);
	 * cq.select(root); Query<Users> query = session.createQuery(cq); return
	 * query.getResultList(); }
	 */

	@Override
	public void delete(Integer UserId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Users user = (Users) session.get(Users.class, UserId);
			session.delete(user);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public Boolean authenticate(String username, String password) {
		Session session = sessionFactory.openSession();
		boolean userFound = false;

		String SQL_QUERY = "from Users where username = ? and  password = ?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;

	}

	@Override
	public Users fetchUser(String username, String password, String pin) {
		Session session = sessionFactory.openSession();
		Users userFound = null;
		// Query using Hibernate Query Language
		String SQL_QUERY = "from Users as o where (o.username=? and o.password=?) or o.pin=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, username);
		query.setParameter(1, password);
		query.setParameter(2, pin);

		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = (Users) list.get(0);
		}

		session.close();
		return userFound;
	}

	@Override
	public Integer userRegistration(Users user) {

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

		return user.getId();

	}

	@Override
	public Users fetchUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		Users userFound = null;
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Users as o where o.userEmail=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, email);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = (Users) list.get(0);
		}

		session.close();
		return userFound;
	}

	@Override
	public Object updateProfile(Users user) {
		ModelMap model = new ModelMap();
		Session session = sessionFactory.openSession();

		Transaction transaction = null;

		try {

			Users userExist = session.byId(Users.class).load(user.getId());
			if (userExist == null) {
				model.put("msg", "user does not exist");
				return model;
			}
			session.clear();
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();

		} catch (Exception ex) {

			transaction.rollback();
			ex.printStackTrace();

		} finally {
			session.close();
		}
		model.put("Success", "1");
		model.put("msg", "Update successfully");
		return model;

	}

	@Override
	public Map<String, Object> resetPassword(Map<String, String> userMap) {
		Map<String, Object> model = new HashMap<String, Object>();
		Session session = sessionFactory.openSession();

		Transaction transaction = null;

		try {

			boolean userFound = false;

			String SQL_QUERY = "from Users o where o.userEmail = ?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0, userMap.get("email"));
			List list = query.list();
			if ((list != null) && (list.size() > 0)) {
				userFound = true;
			}

			if (!userFound) {
				model.put("successCode", "0");
				model.put("msg", "Invalid Email Id");
				return model;
			}
			session.clear();
			transaction = session.beginTransaction();
			SQL_QUERY = "update Users set password=? where userEmail = ?";
			query = session.createQuery(SQL_QUERY);
			query.setParameter(0, userMap.get("password"));
			query.setParameter(1, userMap.get("email"));
			query.executeUpdate();
			transaction.commit();
			model.put("successCode", "1");
			model.put("msg", "Password reset successfully");

		} catch (Exception ex) {

			transaction.rollback();
			ex.printStackTrace();
			model.put("successCode", "0");
			model.put("msg", "Invalid Email Id");

		} finally {
			session.close();
		}
		return model;

	}

	@Override
	public List<Map> getDoctorList(String userType) {
		List<Users> list = new ArrayList<Users>();
		List resultList = new ArrayList();
		Session session = sessionFactory.openSession();
		try {

			String SQL_QUERY = " from Users as o where o.type=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0, userType);
			list = query.list();
			if (!list.isEmpty()) {
				for (Users user : list) {
					String name = user.getPerson().getFullName();
					String hospitalname = user.getPerson().getHospital().getName();
					String address = user.getPerson().getHospital().getAddress();
					String speciality = user.getPerson().getSpeciality();
					String imageurl = user.getPerson().getPhotourl();
					String doctorquickbloxid = user.getExternalid();

					// String hospitalphone =
					// user.getPerson().getHospital().getPhone();
					// String hospitalemail =
					// user.getPerson().getHospital().getEmail();

					Integer id = user.getId();
					Map<String, Object> map = new LinkedHashMap<String, Object>();
					map.put("user_id", id);
					map.put("title", name);
					map.put("Speciality", speciality);
					map.put("HospitalName", hospitalname);
					map.put("HospitalAddress", address);
					map.put("ImageUrl", imageurl);
					map.put("Doctor Quickblox Id", doctorquickbloxid);

					resultList.add(map);
				}

			}
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	@Override
	public Hospital getHospital(Long id) {
		Session session = sessionFactory.openSession();
		Hospital hospital = null;
		try {
			hospital = session.get(Hospital.class, id);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return hospital;
	}

	@Override
	public Users getPerson(Integer id) {

		Session session = sessionFactory.openSession();
		Users user = null;
		try {
			user = session.get(Users.class, id);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return user;

	}

	@Override
	public Object getupload(FileInfo fileInfo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			session.clear();
			transaction = session.beginTransaction();
			session.save(fileInfo);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			session.close();
		}

		return fileInfo;
	}

}
