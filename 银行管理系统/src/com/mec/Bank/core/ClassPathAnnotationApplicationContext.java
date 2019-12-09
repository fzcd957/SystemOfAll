package com.mec.Bank.core;

import java.lang.reflect.Field;

import com.mec.Bank.annotation.Column;
import com.mec.Bank.annotation.ID;
import com.mec.Bank.annotation.Table;
import com.mec.util.PackageScanner;
/**
 * 采用注解方式配置类表，类表中的成员对应关系；
 * @author 余生
 */
public class ClassPathAnnotationApplicationContext extends ClassPathApplicationContext {
	
	ClassPathAnnotationApplicationContext(String packageName) {
		ClassTableFactory ctf = new ClassTableFactory();
		
		new PackageScanner() {
			@Override
			public void dealClass(Class<?> klass) {
				if (klass.isPrimitive()
						|| klass.isArray()
						|| klass.isInterface()
						|| klass.isAnnotation()
						|| klass.isEnum()
						|| !klass.isAnnotationPresent(Table.class)) {
					return;
				}
				Table table = klass.getAnnotation(Table.class);
				String tableName = table.value();
				
				ClassTableDefinition ctd = new ClassTableDefinition();
				set(ctd, klass, tableName);
				
				scanFields(klass, ctd);
				try {
					scanFields(klass.getDeclaredFields(), ctd);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				ctf.addClassTableDefinition(klass.getName(), ctd);
			}
		}.scannerPackage(packageName);
	}
	
	private void scanFields(Field[] fields, ClassTableDefinition ctd)
			throws Exception {
		for (Field field : fields) {
			PropertyColumn pc = ctd.getPropertyColumn(field);
			if (field.isAnnotationPresent(ID.class)) {
				setID(ctd, pc);
			}
			
			if (!field.isAnnotationPresent(Column.class)) {
				continue;
			}
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value();
			set(pc, field, columnName);
		}
	}
	
}
