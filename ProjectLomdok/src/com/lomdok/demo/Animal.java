package com.lomdok.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Here are a list of other cool feature in the Lombok API.
 * 
 * No more overriding toString We can now annotate our class with a @ToString
 * and lombok will override our toString method and print out the classes
 * fields.
 * 
 * No more overriding equals and hashCode methods. Annotate class with @EqualsAndHashCode
 * for easy generation of equals and hashCode methods at compile time.
 * 
 * Generates constructors based on class annotations.
 * 
 * @NoArgsConstructor used for creating a no argument constructor.
 * @RequiredArgsConstructor used for creating constructor that takes one
 *                          argument per non final/ non-null fields.
 * @AllArgsConstructor used for creating constructor takes in one argument for
 *                     every field.
 * 
 *                     Use @Data shortcut for @ToString, @EqualsAndHashCode, @
 *                     RequiredArgsConstructor, and @Getter / @Setter (on all
 *                     non final fields).
 * 
 * 
 * @author Administrator
 *
 */
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Animal {

	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String gender;
	@Getter
	@Setter
	private String species;
}
