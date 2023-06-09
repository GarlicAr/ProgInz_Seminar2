package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "grade_table")
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Grade {
	
	@Column(name = "grade_id")
	@Setter(value = AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gradeId;
	
	@Column(name = "grade_value")
	@Min(value = 1)
	@Max(value = 10)
	private int gradeValue;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	

	public Grade(@Min(1) @Max(10) int gradeValue, Student student, Course course) {
		super();
		this.gradeValue = gradeValue;
		this.student = student;
		this.course = course;
	}


	
	
	
	
	
	
	
}
