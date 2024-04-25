package unah.edu.lenguajes1700.proyecto.Service;

import java.util.List;

import unah.edu.lenguajes1700.proyecto.Entities.Comprador;

public interface CompradorService {

    public Comprador registrarNuevoComprador(Comprador comprador);

    public Comprador autenticarComprador(String correoelectronico, String contrasena);

    public Comprador obtenerCompradorPorId(int idcomprador);

    public List<Comprador> obtenerTodosLosCompradores();

    public void eliminarComprador(int idcomprador);

    public void actualizarComprador(int idcomprador, Comprador compradoractualizado);
}
