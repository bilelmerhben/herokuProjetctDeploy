package com.courzelo.espace_formateur.course.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExtremCourse {
	 private String name;
	 private List<KolbPhase> phases;
}
