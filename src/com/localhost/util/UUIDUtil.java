package com.localhost.util;

import java.util.UUID;

/**
 * 生成随机字符串工具类
 * @author Administrator
 *
 */
public class UUIDUtil {

	/**
	 * 获取随机字符串
	 * @return
	 */
	public static String getUUID() {
		// UUID生成的字符串中包含"-"
		return UUID.randomUUID().toString().replace("-", "");
	}
}
