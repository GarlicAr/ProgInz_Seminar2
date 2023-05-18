package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "grade_table")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Grade {
	
	@Column(name = "grade_id")
	@Setter(value = AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gradeId;
	
	@Column(name = "grade_value")
	@Size(min = 1, max = 10)
	private int value;
	
	
	
}
