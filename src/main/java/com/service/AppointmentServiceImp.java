package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AppointmentDao;
import com.models.Appointment;
/*
@Service
@Transactional(readOnly = true)*/
public class AppointmentServiceImp //implements AppointmentService 
{
/*
   @Autowired
   private AppointmentDao appointmentDao;

   @Transactional
   @Override
   public long save(Appointment appointment) {
      return appointmentDao.save(appointment);
   }

   @Override
   public Appointment get(long id) {
      return appointmentDao.get(id);
   }

   @Override
   public List<Appointment> list() {
      return appointmentDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Appointment appointment) {
	   appointmentDao.update(id, appointment);
   }

   @Transactional
   @Override
   public void delete(long id) {
	   appointmentDao.delete(id);
   }
*/
}