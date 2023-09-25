package com.practice.PersonJPA;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.PersonJPA.DAO.PersonDao;
import com.practice.PersonJPA.models.Person;

@SpringBootApplication
public class PersonJpaApplication implements CommandLineRunner{
	@Autowired
	PersonDao persondao;
	public static void main(String[] args) {
		SpringApplication.run(PersonJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the any number for CRUD");
		System.out.println("1.Get the Person");
		System.out.println("2.Insert Person");
		System.out.println("3.Update Person");
		System.out.println("4.Delete Person");
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the Person id to get Person Details");
			int getId=in.nextInt();
			Person person=persondao.getPerson(getId);
			System.out.println(person);
			break;
			
		case 2:
			in.nextLine();
			System.out.println("Enter the Person Name");
			String getName=in.nextLine();
			System.out.println("Enter the Person Age");
			int getAge=in.nextInt();
			Person insertPerson=new Person(getName,getAge);
			persondao.savePerson(insertPerson);
			break;
			
		case 3:
			System.out.println("Enter the field to update");
			System.out.println("1.Name");
			System.out.println("2.Age");
			in.nextLine();
			int updateChoice=in.nextInt();
			switch(updateChoice) {
			case 1:
				System.out.println("Enter the id to update");
				int updateId=in.nextInt();
				System.out.println("Enter the new name");
				in.nextLine();
				String newName=in.nextLine();
				persondao.updateName(updateId, newName);
				break;
				
			case 2:
				System.out.println("Enter the id to update");
				int updateIdForAge=in.nextInt();
				System.out.println("Enter the new Age");
				int newAge=in.nextInt();
				persondao.updateAge(updateIdForAge, newAge);
				break;
			}
			break;
			
		case 4:
			
			System.out.println("Enter the id to delete");
			int deleteId=in.nextInt();
			persondao.deletePerson(deleteId);
			break;	
			
		}
	}

}
