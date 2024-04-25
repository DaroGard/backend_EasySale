package unah.edu.lenguajes1700.proyecto.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.DetalleFactura;

@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Integer> {

    List<DetalleFactura> findByFacturaIdfactura(int idfactura);

}
