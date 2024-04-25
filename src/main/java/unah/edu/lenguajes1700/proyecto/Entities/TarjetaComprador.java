package unah.edu.lenguajes1700.proyecto.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Tarjetas_Compradores")
public class TarjetaComprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtarjetacomprador;

    private String numerotarjetacomprador;

    private LocalDate fechavencimientocomprador;

    private String codigoseguridadcomprador;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;
}