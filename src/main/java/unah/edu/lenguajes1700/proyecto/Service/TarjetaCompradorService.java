package unah.edu.lenguajes1700.proyecto.Service;

import java.util.List;

import unah.edu.lenguajes1700.proyecto.Entities.TarjetaComprador;

public interface TarjetaCompradorService {

    public TarjetaComprador agregarTarjeta(TarjetaComprador tarjetacomprador);

    public TarjetaComprador obtenerTarjetaPorId(int tarjetacomprador);

    public List<TarjetaComprador> obtenerTarjetasPorComprador(int idcomprador);

    public TarjetaComprador actualizarTarjetaComprador(int idtarjetacomprador,
            TarjetaComprador tarjetaCompradoractualizada);
}
