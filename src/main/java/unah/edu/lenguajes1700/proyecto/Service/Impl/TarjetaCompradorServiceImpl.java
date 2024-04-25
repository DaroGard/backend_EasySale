package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.TarjetaComprador;
import unah.edu.lenguajes1700.proyecto.Repository.TarjetaCompradorRepository;
import unah.edu.lenguajes1700.proyecto.Service.TarjetaCompradorService;

@Service
public class TarjetaCompradorServiceImpl implements TarjetaCompradorService {

    @Autowired
    private TarjetaCompradorRepository tarjetaCompradorRepository;

    @Override
    public TarjetaComprador agregarTarjeta(TarjetaComprador tarjetacomprador) {
        // Asociar la tarjeta al comprador y guardarla en la base de datos
        return tarjetaCompradorRepository.save(tarjetacomprador);
    }

    @Override
    public TarjetaComprador obtenerTarjetaPorId(int idtarjeta) {
        // Obtener la tarjeta por su ID
        return tarjetaCompradorRepository.findById(idtarjeta).orElse(null);
    }

    @Override
    public List<TarjetaComprador> obtenerTarjetasPorComprador(int idcomprador) {
        // Obtener todas las tarjetas asociadas a un comprador por su ID
        return tarjetaCompradorRepository.findByComprador_Idcomprador(idcomprador);
    }

    @Override
    public TarjetaComprador actualizarTarjetaComprador(int idtarjetacomprador,
            TarjetaComprador tarjetaCompradoractualizada) {
        TarjetaComprador tarjetaExistente = tarjetaCompradorRepository.findById(idtarjetacomprador)
                .orElseThrow(() -> new RuntimeException(
                        "No se encontró la tarjeta del comprador con ID: " + idtarjetacomprador));

        // Actualizar los campos proporcionados en el objeto tarjetaCompradorActualizada
        if (tarjetaCompradoractualizada.getNumerotarjetacomprador() != null) {
            tarjetaExistente.setNumerotarjetacomprador(tarjetaCompradoractualizada.getNumerotarjetacomprador());
        }
        if (tarjetaCompradoractualizada.getFechavencimientocomprador() != null) {
            tarjetaExistente.setFechavencimientocomprador(tarjetaCompradoractualizada.getFechavencimientocomprador());
        }
        if (tarjetaCompradoractualizada.getCodigoseguridadcomprador() != null) {
            tarjetaExistente.setCodigoseguridadcomprador(tarjetaCompradoractualizada.getCodigoseguridadcomprador());
        }

        // Guardar la tarjeta del comprador actualizada en la base de datos
        return tarjetaCompradorRepository.save(tarjetaExistente);
    }
}
