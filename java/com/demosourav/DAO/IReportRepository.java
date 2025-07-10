package com.demosourav.DAO;

import java.util.List;

import com.demosourav.model.RoomUsageReport;

public interface IReportRepository {

	public List<RoomUsageReport> getRoomUtilization();

}
