package unah.edu.lenguajes1700.proyecto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

    Vendedor findByCorreoelectronico(String correoelectronico);

}