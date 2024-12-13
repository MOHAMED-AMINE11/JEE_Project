package com.GestionSurveillance.JEE.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String module;

    private String date;
    private String horaire;

    private int nbEtudiants;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id")

    private Session session;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToMany
    private List<Local> locaux;

    public List<Local> getLocaux() {
        return locaux;
    }

    public void setLocaux(List<Local> locaux) {
        this.locaux = locaux;
    }

}
