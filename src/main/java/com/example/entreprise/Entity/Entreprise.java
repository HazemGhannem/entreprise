package com.example.entreprise.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "T_ENTREPRISE")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENTREPRISE_ID")
	private Long idEntreprise; // Identifiant entreprise (Clé primaire)

	@Column(name = "ENTREPRISE_NOM")
	private String nom;

	@Column(name = "ENTREPRISE_ADRESSE")
	private String adresse;

	@ToString.Exclude
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entreprise")
	private Set<Equipe> Equipes;
}
