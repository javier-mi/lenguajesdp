package edu.caece.lenguajesdeprogramacion.tpfinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Equation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(length = 100*1000)
	private String description;
	
	@Column(length = 100*1000)
	private String equationData;

	public Equation(String name, String description, String equationData) {
		super();
		this.name = name;
		this.description = description;
		this.equationData = equationData;
	}

}
