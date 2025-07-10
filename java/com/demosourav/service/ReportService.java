package com.demosourav.service;

import java.util.List;

import com.demosourav.model.RoomUsageReport;
import com.demosourav.DAO.*;
import com.demosourav.DAO.IMP.*;

public class ReportService {
	
	public List<RoomUsageReport> getRoomUtilization(){
		IReportRepository repo = new ReportRepositoryImpl();
		return repo.getRoomUtilization();
		
	}

}
