package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.models.Degree;


@Table(name="Table_Student")
@Entity
@Getter
@Setter
@ToString
public class Student extends Person{
	
	

	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Collection<Grade> grades;
	

	public Student(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname) {
		super(name, surname);
	}
	
	
	

	
	
	
	
	
	
}
