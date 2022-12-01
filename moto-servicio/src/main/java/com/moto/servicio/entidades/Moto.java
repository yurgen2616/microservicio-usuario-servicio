package com.moto.servicio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter int id;

    private @Getter @Setter String marca;
    private @Getter @Setter String modelo;
    private @Getter @Setter int usuarioId;
}
