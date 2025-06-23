package com.maven.maven_mysql_project;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return Double.compare(o2.getSalary(), o1.getSalary()); // asc
	}

}
