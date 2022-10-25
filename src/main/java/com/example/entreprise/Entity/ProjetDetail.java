package com.example.entreprise.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_PROJET_DETAIL")
@Getter
@Setter

public class ProjetDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PD_ID")
	private Long idProjetDetail; // Identifiant projet detail (Clé primaire)

	@Column(name = "PD_DESCRIPTION")
	private String description;

	@Column(name = "PD_TECHNOLOGIE")
	private String technologie;

	@Column(name = "PD_COUT_PROVISOIRE")
	private Long cout_provisoire;

	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@JsonIgnore
	@OneToOne(mappedBy = "projetDetail")
	private Projet projet;

}
