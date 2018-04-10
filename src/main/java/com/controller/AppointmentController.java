package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.Appointment;
import com.service.AppointmentService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppointmentController {

  /* @Autowired
   private AppointmentService appointmentService;

   ---Add new book---
   @PostMapping("/appointment/create")
   public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
	  long id = appointmentService.save(appointment);
      return ResponseEntity.ok().body(appointment);
   }

   ---Get a book by id---
   @GetMapping("/appointment/{id}")
   public ResponseEntity<Appointment> get(@PathVariable("id") long id) {
	   Appointment appointment = appointmentService.get(id);
      return ResponseEntity.ok().body(appointment);
   }

   ---get all books---
   @GetMapping("/appointments")
   public ResponseEntity<List<Appointment>> list() {
      List<Appointment> appointments = appointmentService.list();
      return ResponseEntity.ok().body(appointments);
   }

   ---Update a book by id---
   @PutMapping("/appointment/update/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Appointment appointment) {
	   appointmentService.update(id, appointment);
      return ResponseEntity.ok().body("Appointment has been updated successfully.");
   }

   ---Delete a book by id---
   @DeleteMapping("/appointment/delete/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	  appointmentService.delete(id);
      return ResponseEntity.ok().body("Appointment has been deleted successfully.");
   }*/
}