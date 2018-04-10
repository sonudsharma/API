package com.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.models.Appointment;
//import com.models.User;

//@Repository
public class AppointmentDaoImp //implements AppointmentDao 
{

  /* @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Appointment appointment) {
      sessionFactory.getCurrentSession().save(appointment);
      return appointment.getId();
   }

   @Override
   public Appointment get(long id) {
      return sessionFactory.getCurrentSession().get(Appointment.class, id);
   }

   @Override
   public List<Appointment> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Appointment> cq = cb.createQuery(Appointment.class);
      Root<Appointment> root = cq.from(Appointment.class);
      cq.select(root);
      Query<Appointment> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Appointment appointment) {
      Session session = sessionFactory.getCurrentSession();
      Appointment appointmenttemp = session.byId(Appointment.class).load(id);
      appointmenttemp.setDoctorName(appointment.getDoctorName());
      appointmenttemp.setPatientName(appointment.getPatientName());
      appointmenttemp.setDiseaseName(appointment.getDiseaseName());
      appointmenttemp.setPhone(appointment.getPhone());
      appointmenttemp.setDate(appointment.getDate());
      
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Appointment appointment = session.byId(Appointment.class).load(id);
      session.delete(appointment);
   }*/

}