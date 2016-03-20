/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xspro
 *
 */

@Entity
@Table(name = "STUDENT")
public class Student implements DBHibernateObject {
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "studentName")
	private String name;

	@Column(name = "age")
	private int age;

	/**
	 * @param id
	 * @param name
	 * @param age
	 */
	public Student(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

}
