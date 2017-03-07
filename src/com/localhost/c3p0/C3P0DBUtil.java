package com.localhost.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0DBUtil {

	private static C3P0DBUtil pool;
    private static ComboPooledDataSource ds;

    private C3P0DBUtil() {
    	ds = new ComboPooledDataSource();
    }
    
    public static C3P0DBUtil getInstance() {
    	if (pool == null) {
    		synchronized (C3P0DBUtil.class) {
				if (pool == null) {
					pool = new C3P0DBUtil();
				}
			}
		}
    	return pool;
    }
    
    public synchronized final Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
