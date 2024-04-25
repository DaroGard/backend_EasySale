package unah.edu.lenguajes1700.proyecto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.DireccionComprador;

@Repository
public interface DireccionCompradorRepository extends CrudRepository<DireccionComprador, Integer> {

}
