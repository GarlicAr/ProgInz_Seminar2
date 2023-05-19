package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Table_Professor")
@Entity
@Getter
@Setter
@ToString
public class Professor extends Person{


	
	
	@Column(name = "professor_degree")
	@NotNull
	private Degree degree;

	@ManyToMany(mappedBy = "professor")
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();

	public Professor(String name, String surname, Degree degree) {

		super(name, surname);
		this.degree = degree;
	}

	public void addCourse(Course input) {

		if (!courses.contains(input)) {
			courses.add(input);
		}

	}

}
