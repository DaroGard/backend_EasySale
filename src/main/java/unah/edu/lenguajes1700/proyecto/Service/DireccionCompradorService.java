package unah.edu.lenguajes1700.proyecto.Service;

import unah.edu.lenguajes1700.proyecto.Entities.DireccionComprador;

public interface DireccionCompradorService {

    public DireccionComprador agregarDireccion(DireccionComprador direccion);

    public DireccionComprador actualizarDireccion(int iddireccion, DireccionComprador direccionactualizada);

    public void eliminarDireccion(int iddireccion);

    public DireccionComprador obtenerDireccionPorId(int iddireccion);
}
