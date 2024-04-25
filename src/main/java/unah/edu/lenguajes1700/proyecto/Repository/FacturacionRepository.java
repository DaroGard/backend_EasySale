package unah.edu.lenguajes1700.proyecto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.Facturacion;

@Repository
public interface FacturacionRepository extends CrudRepository<Facturacion, Integer> {

}
