package com.spring1024.util;

import java.util.UUID;

public class UuidBean {
	public static String GetUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
