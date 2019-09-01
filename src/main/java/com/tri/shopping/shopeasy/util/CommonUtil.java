package com.tri.shopping.shopeasy.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class contains common utility methods
 * 
 * @author Archana Trimukhe
 *
 */
public class CommonUtil {

	/**
	 * applied singleton while getting instance of CommonUtil class
	 */
	private static final CommonUtil commonUtil = new CommonUtil();
	/**
	 * instance of ObjectMapper while performing parser related methods
	 */
	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * Find and returns the file object for given file name
	 * 
	 * @param fileName file name
	 * @return {@File}
	 */
	public File getFile(String fileName) {
		return new File(getClass().getClassLoader().getResource(fileName).getFile());
	}

	/**
	 * Provide object of this class to perform common utility operations
	 * 
	 * @return
	 */
	public static CommonUtil getInstance() {
		return commonUtil;
	}
	
	/**
	 * applied singleton design pattern
	 */
	private CommonUtil() {}

	/**
	 * Used to read input {@File}, parse it using jackson and return respective Java
	 * object
	 * 
	 * @param file      json file which need to read
	 * @param className java mapper class for read file
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object unmarshall(File file, @SuppressWarnings("rawtypes") Class className) {
		try {
			return mapper.readValue(file, className);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method take java Object and returns the String representation of json
	 * file
	 * 
	 * @param object java object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String toString(Object object) throws JsonProcessingException {
		return (object == null) ? null : mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}
}
