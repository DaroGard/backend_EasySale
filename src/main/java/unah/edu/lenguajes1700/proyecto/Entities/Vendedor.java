package unah.edu.lenguajes1700.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vendedores")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvendedor;

    private String nombrevendedor;

    private String descripcion;

    private String correoelectronico;

    private String contrasena;

    private Integer cuentavendedor;
}