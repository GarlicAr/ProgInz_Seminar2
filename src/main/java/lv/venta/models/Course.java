package lv.venta.models;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="Table_Course")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
	
	@Column(name = "course_title")
	@Size(min = 5, max = 25)
	private String title;
	
	@Column(name = "course_creditpoints")
	@Min(value = 1)
	@Max(value = 4)
	private int creditPoints;

	@Column(name = "course_id")
	@Id
	@Setter(value = AccessLevel.NONE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseId;
	
	@OneToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	private Collection<Grade> grades;

	public Course(@Size(min = 5, max = 25) String title, @Min(1) @Max(4) int creditPoints, Professor professor) {

		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}
	

	
	
	
	

}
