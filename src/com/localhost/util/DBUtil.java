package com.localhost.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {

	private static DBUtil pool;
    private static ComboPooledDataSource ds;

    private DBUtil() {
    	ds = new ComboPooledDataSource();
    }
    
    public static DBUtil getInstance() {
    	if (pool == null) {
    		synchronized (DBUtil.class) {
				if (pool == null) {
					pool = new DBUtil();
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
