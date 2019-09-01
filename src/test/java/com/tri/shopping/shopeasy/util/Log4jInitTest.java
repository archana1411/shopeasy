package com.tri.shopping.shopeasy.util;

import org.junit.Test;

import junit.framework.TestCase;

public class Log4jInitTest extends TestCase {

	@Test
	public void testGetInstance() {
		assertNotNull(Log4jInit.getInstance());
	}
}
