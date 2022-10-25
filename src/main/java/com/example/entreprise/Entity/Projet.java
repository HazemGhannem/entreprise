package com.example.entreprise.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "T_PROJET")
@ToString
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJET_ID")
	private Long idProjet; // Identifiant projet (Clé primaire)

	@Column(name = "PROJET_SUJET")
	private String sujet;

	@OneToOne
	private ProjetDetail projetDetail;

	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(mappedBy = "projets", cascade = CascadeType.ALL)
	private Set<Equipe> equipes;

}
