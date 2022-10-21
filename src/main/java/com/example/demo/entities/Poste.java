package com.example.demo.entities;



import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Poste {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String choix;
	@OneToMany(mappedBy="poste")
	private List<candidat>candidats;
	public void add(Poste poste) {
		// TODO Auto-generated method stub
		
	}
}
