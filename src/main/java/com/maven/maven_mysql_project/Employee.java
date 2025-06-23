package com.maven.maven_mysql_project;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor // default
@ToString
@EqualsAndHashCode
public class Employee {

	private Integer empId;
	private String empName;
	private String department;
	private double salary;
	
	
	

}
