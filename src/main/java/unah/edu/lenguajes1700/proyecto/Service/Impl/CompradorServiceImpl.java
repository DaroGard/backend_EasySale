package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.Comprador;
import unah.edu.lenguajes1700.proyecto.Repository.CompradorRepository;
import unah.edu.lenguajes1700.proyecto.Service.CompradorService;

@Service
public class CompradorServiceImpl implements CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Override
    public Comprador registrarNuevoComprador(Comprador comprador) {
        // Verifica si ya existe un comprador con el mismo correo electrónico
        Comprador compradorExistente = compradorRepository.findByCorreoelectronico(comprador.getCorreoelectronico());
        if (compradorExistente != null) {
            // Si ya existe un comprador con el mismo correo electrónico, lanza una
            // excepción.
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        // Si el correo electrónico no está registrado, guardar el nuevo comprador
        return compradorRepository.save(comprador);
    }

    @Override
    public Comprador autenticarComprador(String correoelectronico, String contrasena) {
        // Buscar el comprador por su correo electrónico
        Comprador comprador = compradorRepository.findByCorreoelectronico(correoelectronico);
        // Verificar si el comprador existe y si la contraseña es correcta
        if (comprador != null && contrasena.equals(comprador.getContrasena())) {
            return comprador; // El comprador y la contraseña son válidos
        }
        return null; // El comprador no existe o la contraseña es incorrecta
    }

    @Override
    public Comprador obtenerCompradorPorId(int idcomprador) {
        // Obtener el comprador por su ID
        return compradorRepository.findById(idcomprador).orElse(null);
    }

    @Override
    public List<Comprador> obtenerTodosLosCompradores() {
        // Obtener todos los compradores de la base de datos
        return (List<Comprador>) compradorRepository.findAll();
    }

    @Override
    public void eliminarComprador(int idcomprador) {
        // Eliminar el comprador por su ID
        compradorRepository.deleteById(idcomprador);
    }

    @Override
    public void actualizarComprador(int idcomprador, Comprador compradoractualizado) {
        Comprador comprador = compradorRepository.findById(idcomprador)
                .orElseThrow(() -> new RuntimeException("No se encontró el comprador con ID: " + idcomprador));

        // Actualizar los campos proporcionados en el objeto compradoractualizado
        if (compradoractualizado.getNombre() != null) {
            comprador.setNombre(compradoractualizado.getNombre());
        }
        if (compradoractualizado.getApellido() != null) {
            comprador.setApellido(compradoractualizado.getApellido());
        }
        if (compradoractualizado.getTelefono() != null) {
            comprador.setTelefono(compradoractualizado.getTelefono());
        }
        if (compradoractualizado.getCorreoelectronico() != null) {
            comprador.setCorreoelectronico(compradoractualizado.getCorreoelectronico());
        }
        if (compradoractualizado.getContrasena() != null) {
            comprador.setContrasena(compradoractualizado.getContrasena());
        }

        // Guardar el comprador actualizado en la base de datos
        compradorRepository.save(comprador);
    }
}
