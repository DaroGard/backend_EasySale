package unah.edu.lenguajes1700.proyecto.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Detalle_Factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numerofactura;

    @ManyToOne
    @JoinColumn(name = "idfactura")
    private Facturacion factura;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    private Integer cantidad;

    private Integer descuento;

    @Column(precision = 10, scale = 2)
    private BigDecimal subtotal;

    private String estadopago;

    private LocalDate fechaentrega;
}
