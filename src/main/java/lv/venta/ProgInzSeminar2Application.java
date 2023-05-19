package lv.venta;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar2Application.class, args);
	}
	
	
	@Bean //Calls function when system runs
	public CommandLineRunner testModel(
			ICourseRepo courseRep, 
			IProfessorRepo professorRep, 
			IGradeRepo gradeRep, 
			IStudentRepo studentRep ) {
		
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				
				Professor prof1 = new Professor("Andris", "Egitis", Degree.none);
				Professor prof2 = new Professor("Raita", "Rolande", Degree.mg);
				Professor prof3 = new Professor("Karina", "Skirmante", Degree.mg);
				professorRep.save(prof1);
				professorRep.save(prof2);
				professorRep.save(prof3);
				
				Student stud1 = new Student("Arvids", "Ivbuls");
				Student stud2 = new Student("Juris", "Palcevskis");
				studentRep.save(stud1);
				studentRep.save(stud2);
				
				Course c1 = new Course("Programmesanasinzenierija", 4, prof3);
				Course c2 = new Course("Sports", 2, prof1);
				Course c3 = new Course("Fizika", 3, prof2);
				courseRep.save(c1);
				courseRep.save(c2);
				
				gradeRep.save(new Grade(10, stud1, c1));
				gradeRep.save(new Grade(6, stud2, c1));
				gradeRep.save(new Grade(10, stud1, c2));
				gradeRep.save(new Grade(7, stud2, c2));
				
				
			}
		};
	}

}
