package com.runjetty.webservice;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.MedicineDAO;
import pojo.Medicine;
import pojo.Message;

@Path("/medicine")
public class TestWebService {

	// -----------------------------------------------------------------------------------
	// Service method for getting specific user's medicines
	// -----------------------------------------------------------------------------------
	@GET
	@Path("/getUserMedicines")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserMedicines(@QueryParam("userEmail") String userEmail) {
		Message message = new Message();
		Medicine medicine = new Medicine();
		MedicineDAO medicineDAO = new MedicineDAO();

		ArrayList<Medicine> medicines = medicineDAO.getUserMedicines(userEmail);
		if (medicines.size() >= 1) {
			return medicine.convertMedicinesIntoJson(medicines);
		} else {
			return message.convertMessageIntoJson(new Message(false));
		}

	}		
}
