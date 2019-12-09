package com.mec.Bank.core;

import java.util.HashMap;
import java.util.Map;
/**
  * 这个类用来产生factoryMap 
  * 键为类名，值为ClassTableDefinition
 * @author 余生
 */
public class ClassTableFactory {
	static final Map<String, ClassTableDefinition> classTableMap = new HashMap<>();
	
	ClassTableFactory() {
	}
	
	void addClassTableDefinition(String className, ClassTableDefinition ctd) {
		if (classTableMap.containsKey(className)) {
			return;
		}

		classTableMap.put(className, ctd);
	}
	
	static ClassTableDefinition getClassTable(String className) {
		return classTableMap.get(className);
	}
	
	static ClassTableDefinition getClassTable(Class<?> klass) {
		return getClassTable(klass.getName());
		
	}
	
}
