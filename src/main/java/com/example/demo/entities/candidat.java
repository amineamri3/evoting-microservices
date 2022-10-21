package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class candidat {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nom;
private String prenom;
private Date dateNaissance;
private String status;
@ManyToOne
@JoinColumn(name="Id_POSTE")
private Poste poste;
}
