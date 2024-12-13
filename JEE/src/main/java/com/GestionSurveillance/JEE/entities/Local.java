package com.GestionSurveillance.JEE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nom;

	@NotNull
	private int capacite;

	private boolean estDisponible;

	private int nbSurveillance;
	@OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
	private List<Surveillance> surveillances;

	@ManyToMany(mappedBy = "locaux")
	private List<Examen> examens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public boolean isEstDisponible() {
		return estDisponible;
	}

	public void setEstDisponible(boolean estDisponible) {
		this.estDisponible = estDisponible;
	}

	public int getNbSurveillance() {
		return nbSurveillance;
	}

	public void setNbSurveillance(int nbSurveillance) {
		this.nbSurveillance = nbSurveillance;
	}

	public List<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(List<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

}
