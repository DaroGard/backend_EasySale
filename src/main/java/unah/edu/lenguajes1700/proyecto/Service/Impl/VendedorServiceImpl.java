package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.Vendedor;
import unah.edu.lenguajes1700.proyecto.Repository.VendedorRepository;
import unah.edu.lenguajes1700.proyecto.Service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public Vendedor registrarNuevoVendedor(Vendedor vendedor) {
        // Verifica si ya existe un comprador con el mismo correo electrónico.
        Vendedor vendedorExistente = vendedorRepository.findByCorreoelectronico(vendedor.getCorreoelectronico());
        if (vendedorExistente != null) {
            // Si ya existe un comprador con el mismo correo electrónico, lanza una
            // excepción, envia un mensaje de error.
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        // Si el correo electrónico no está registrado, guardar el nuevo comprador.
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor autenticarVendedor(String correoelectronico, String contrasena) {
        // Buscar el vendedor por su correo electrónico
        Vendedor vendedor = vendedorRepository.findByCorreoelectronico(correoelectronico);
        // Verificar si el vendedor existe y si la contraseña es correcta
        if (vendedor != null && contrasena.equals(vendedor.getContrasena())) {
            return vendedor; // El vendedor y la contraseña son válidos
        }
        return null; // El vendedor no existe o la contraseña es incorrecta
    }

    @Override
    public Vendedor obtenerVendedorPorId(int idvendedor) {
        // Obtener el vendedor por su ID
        return vendedorRepository.findById(idvendedor).orElse(null);
    }

    @Override
    public void eliminarVendedor(int idvendedor) {
        // Eliminar el vendedor por su ID
        vendedorRepository.deleteById(idvendedor);
    }

    @Override
    public List<Vendedor> obtenerTodosLosVendedores() {
        return (List<Vendedor>) vendedorRepository.findAll();
    }

    @Override
    public void actualizarVendedor(int idvendedor, Vendedor vendedoractualizado) {
        Vendedor vendedor = vendedorRepository.findById(idvendedor)
                .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));

        // Actualizar los campos proporcionados en el objeto vendedoractualizado
        if (vendedoractualizado.getNombrevendedor() != null) {
            vendedor.setNombrevendedor(vendedoractualizado.getNombrevendedor());
        }
        if (vendedoractualizado.getDescripcion() != null) {
            vendedor.setDescripcion(vendedoractualizado.getDescripcion());
        }
        if (vendedoractualizado.getCorreoelectronico() != null) {
            vendedor.setCorreoelectronico(vendedoractualizado.getCorreoelectronico());
        }
        if (vendedoractualizado.getContrasena() != null) {
            vendedor.setContrasena(vendedoractualizado.getContrasena());
        }
        if (vendedoractualizado.getCuentavendedor() != null) {
            vendedor.setCuentavendedor(vendedoractualizado.getCuentavendedor());
        }

        // Guardar el vendedor actualizado en la base de datos
        vendedorRepository.save(vendedor);
    }
}
