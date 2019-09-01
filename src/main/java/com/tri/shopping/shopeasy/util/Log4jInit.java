package com.tri.shopping.shopeasy.util;

import java.util.logging.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import com.tri.shopping.shopeasy.constant.ShoppingConstant;

public class Log4jInit {
	private static final Log4jInit log4jInit = new Log4jInit();
	private static final Logger LOGGER = Logger.getLogger(Log4jInit.class.getName());
	private CommonUtil commonUtil = CommonUtil.getInstance();

	/**
	 * initialize logger
	 */
	public void init() {
		DOMConfigurator.configure(commonUtil.getFile(ShoppingConstant.LOG_FILE).getAbsolutePath());
		LOGGER.info("logger initialized");
	}

	/**
	 * applied singleton design pattern
	 */
	private Log4jInit() {}
	
	/**
	 * fetch {@Log4jInit}
	 * 
	 * @return
	 */
	public static Log4jInit getInstance() {
		return log4jInit;
	}
}
