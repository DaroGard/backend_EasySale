package unah.edu.lenguajes1700.proyecto.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1700.proyecto.Entities.TarjetaComprador;

@Repository
public interface TarjetaCompradorRepository extends CrudRepository<TarjetaComprador, Integer> {

    List<TarjetaComprador> findByComprador_Idcomprador(int idcomprador);

}