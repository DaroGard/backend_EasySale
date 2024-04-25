package unah.edu.lenguajes1700.proyecto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.Comprador;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Integer> {

    Comprador findByCorreoelectronico(String correoElectronico);

}