package unah.edu.lenguajes1700.proyecto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
