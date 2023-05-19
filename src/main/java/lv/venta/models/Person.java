package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@MappedSuperclass
@Data
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "person_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idpe;
	
	@Column(name = "student_name")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String name;
	
	@Column(name = "student_surname")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String surname;
	
	
	
	
}
