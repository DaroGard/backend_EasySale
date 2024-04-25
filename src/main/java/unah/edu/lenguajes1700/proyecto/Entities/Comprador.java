package unah.edu.lenguajes1700.proyecto.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "compradores")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcomprador;

    private String nombre;

    private String apellido;

    private String telefono;

    private String correoelectronico;

    private String contrasena;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TarjetaComprador> tarjetasComprador;
}