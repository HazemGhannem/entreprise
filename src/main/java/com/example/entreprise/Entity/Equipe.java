package com.example.entreprise.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "T_EQUIPE")
public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQUIPE_ID")
	private Long idEquipe; // Identifiant equipe (Clé primaire)

	@Column(name = "EQUIPE_NOM")
	private String nom;

	@Column(name = "EQUIPE_SPECIALITE")
	private String specialite;

	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	Entreprise entreprise;

	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Projet> projets;

}
