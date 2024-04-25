package unah.edu.lenguajes1700.proyecto.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "facturacion")
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfactura;

    @OneToOne
    @JoinColumn(name = "idcarrito")
    private CarritoCompra carritocompra;

    private LocalDate fechafacturacion;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;
}
