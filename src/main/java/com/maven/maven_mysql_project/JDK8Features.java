package com.maven.maven_mysql_project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JDK8Features {

	public static void main(String[] args) {

		// 1,2,3,4,5,6,7>1.8

		String name[] = { "Sagar", "Ramesh", "Ganesh" };

		System.out.println("Old legacy approach");

		for (int i = 0; i < name.length; i++) {
			if (!name[i].equalsIgnoreCase("Ramesh")) {
				System.out.println(name[i]);
			}
		}

		// Collection

		List<String> names = new LinkedList<>();
		names.add("Sagar");
		names.add("Ramesh");
		names.add("Ganesh");

		// System.out.println(names);

		System.out.println("New approach..........................................................");

		names.parallelStream().filter(s -> !s.equalsIgnoreCase("Ramesh")).forEach(System.out::println);

	}

}
