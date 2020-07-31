package com.cursos_online;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiante;

public class Main {
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

	public static void main(String[] args) {
		
		Curso curso1 = new Curso("Fundamento de Java");
		Curso curso2 = new Curso("Hibernate para Novatos");
		ingresarCurso(curso1);
		ingresarCurso(curso2);
		
		Estudiante est1= new Estudiante("Elvis","Calderon");
		Estudiante est2= new Estudiante("Melanie","Garcia");
		Estudiante est3= new Estudiante("Valeria","Lopez");
		ingresarEstudiante(est1);
		ingresarEstudiante(est2);
		ingresarEstudiante(est3);

	}
	static void ingresarCurso(Curso curso){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(curso);
		
		session.getTransaction().commit();
		session.close();
	}
	static void ingresarEstudiante(Estudiante estudiante){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(estudiante);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(estudiante.getId());
	}

}
