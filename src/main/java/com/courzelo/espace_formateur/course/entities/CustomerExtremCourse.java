package com.courzelo.espace_formateur.course.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerExtremCourse {
	 private String name;
	 private List<CustomerPhase> phases;
	 private String quizzId;
}
