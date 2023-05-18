package lv.venta.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
	private long idp;
	
	@Column(name = "professor_name")
	private String name;
	
	@Column(name = "professor_surname")
	private String surname;
	
	@Column(name = "professor_degree")
	private Degree degree;

	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	

}
