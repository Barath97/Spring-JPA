package com.practice.PersonJPA.DAO;

import org.springframework.stereotype.Repository;

import com.practice.PersonJPA.models.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void savePerson(Person person) {
		em.persist(person);
	}
	
	public Person getPerson(int personId) {
		Person person=em.find(Person.class, personId);
		return person;
	}
	
	public String updateName(int id,String name) {
		Person person=em.find(Person.class, id);
		person.setName(name);
		em.merge(person);
		return name;
	}
	
	public int updateAge(int id,int age) {
		Person person=em.find(Person.class, id);
		person.setAge(age);
		em.merge(person);
		return age;
	}
	
	public void deletePerson(int id) {
		Person person=em.find(Person.class, id);
		em.remove(person);
	}
}
