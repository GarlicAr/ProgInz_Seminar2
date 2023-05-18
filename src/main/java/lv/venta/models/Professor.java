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

@Table(name="Table_Professor")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Professor {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "professor_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@Column(name = "professor_name")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String name;
	
	@Column(name = "professor_surname")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String surname;
	
	@Column(name = "professor_degree")
	@NotNull
	private Degree degree;

	@ManyToMany(mappedBy = "professor")
	@ToString.Exclude
	private Collection<Course> course = new ArrayList<>();
	
	
	public Professor(
			String name, 
			String surname, 
			Degree degree, 
			Collection<Course> courses) {
		
		this.name = name;
		this.surname = surname;
		this.degree = degree;
		this.course = courses;
	}
	
	

}
