package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.DireccionComprador;
import unah.edu.lenguajes1700.proyecto.Repository.DireccionCompradorRepository;
import unah.edu.lenguajes1700.proyecto.Service.DireccionCompradorService;

@Service
public class DireccionCompradorServiceImpl implements DireccionCompradorService {

    @Autowired
    private DireccionCompradorRepository direccionCompradorRepository;

    @Override
    public DireccionComprador agregarDireccion(DireccionComprador direccion) {
        // No es necesario realizar ninguna operación adicional aquí,
        // ya que el comprador asociado se obtiene directamente desde el objeto
        // DireccionComprador
        return direccionCompradorRepository.save(direccion);
    }

    @Override
    public DireccionComprador actualizarDireccion(int iddireccion, DireccionComprador direccionactualizada) {
        DireccionComprador direccionExistente = direccionCompradorRepository.findById(iddireccion)
                .orElseThrow(() -> new RuntimeException("No se encontró la dirección con ID: " + iddireccion));

        // Actualizar los campos opcionales solo si se proporcionan en
        // direccionactualizada
        if (direccionactualizada.getCalle() != null) {
            direccionExistente.setCalle(direccionactualizada.getCalle());
        }
        if (direccionactualizada.getCiudad() != null) {
            direccionExistente.setCiudad(direccionactualizada.getCiudad());
        }
        if (direccionactualizada.getPais() != null) {
            direccionExistente.setPais(direccionactualizada.getPais());
        }

        // Guardar y devolver la dirección actualizada en la base de datos
        return direccionCompradorRepository.save(direccionExistente);
    }

    @Override
    public void eliminarDireccion(int idDireccion) {
        // Eliminar la dirección por su ID
        direccionCompradorRepository.deleteById(idDireccion);
    }

    @Override
    public DireccionComprador obtenerDireccionPorId(int iddireccion) {
        // Obtener la dirección por su ID
        Optional<DireccionComprador> direccionOptional = direccionCompradorRepository.findById(iddireccion);
        return direccionOptional.orElse(null);
    }
}
