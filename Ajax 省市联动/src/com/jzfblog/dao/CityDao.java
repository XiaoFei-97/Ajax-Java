package com.jzfblog.dao;

import java.sql.SQLException;
import java.util.List;

import com.jzfblog.domain.CityBean;


public interface CityDao {
	
	/**
	 * 查询某省份下的所有城市
	 * @param pid 省份id
	 * @return
	 */
	List<CityBean> findCity(int pid) throws SQLException;
}
