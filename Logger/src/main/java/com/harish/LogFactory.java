package com.harish;

import java.util.HashMap;
import java.util.Map;

public class LogFactory {

	static Map<String, Logger> loggerMap = new HashMap<String, Logger>();
	
	public static Logger getInstance(String appName) {
		if(loggerMap.containsKey(appName)) {
			return loggerMap.get(appName);
		}else {
			Logger l = new Logger(appName);
			loggerMap.put(appName, l);
			return l;
		}
	}
}
