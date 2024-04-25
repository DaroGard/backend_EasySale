package unah.edu.lenguajes1700.proyecto.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Carrito_Compras")
public class CarritoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcarrito;

    @ManyToOne
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;

    @OneToMany(mappedBy = "carritocompra")
    private List<Producto> producto;

    private Integer cantidad;

    private String estado;

    private LocalDate fechacreacion;

}
