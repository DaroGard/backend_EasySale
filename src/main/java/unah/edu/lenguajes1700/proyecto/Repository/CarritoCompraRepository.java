package unah.edu.lenguajes1700.proyecto.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.CarritoCompra;

@Repository
public interface CarritoCompraRepository extends CrudRepository<CarritoCompra, Integer> {

    List<CarritoCompra> findByCompradorIdcomprador(int idComprador);

}
