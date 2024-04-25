package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.Producto;
import unah.edu.lenguajes1700.proyecto.Repository.ProductoRepository;
import unah.edu.lenguajes1700.proyecto.Service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        // Guardar el producto en la base de datos
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(int idproducto) {
        // Obtener el producto por su ID
        return productoRepository.findById(idproducto).orElse(null);
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        // Obtener todos los productos de la base de datos
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void eliminarProducto(int idproducto) {
        // Eliminar el producto por su ID
        productoRepository.deleteById(idproducto);
    }

    @Override
    public Producto actualizarProducto(int idproducto, Producto productoactualizado) {
        Producto productoExistente = productoRepository.findById(idproducto)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));

        // Actualizar los campos opcionales solo si se proporcionan en
        // productoActualizado
        if (productoactualizado.getNombre() != null) {
            productoExistente.setNombre(productoactualizado.getNombre());
        }
        if (productoactualizado.getDescripcion() != null) {
            productoExistente.setDescripcion(productoactualizado.getDescripcion());
        }
        if (productoactualizado.getPrecio() != null) {
            productoExistente.setPrecio(productoactualizado.getPrecio());
        }
        if (productoactualizado.getImagen() != null) {
            productoExistente.setImagen(productoactualizado.getImagen());
        }
        if (productoactualizado.getCantidadproducto() != null) {
            productoExistente.setCantidadproducto(productoactualizado.getCantidadproducto());
        }
        if (productoactualizado.getCategoria() != null) {
            productoExistente.setCategoria(productoactualizado.getCategoria());
        }
        if (productoactualizado.getVendedor() != null) {
            productoExistente.setVendedor(productoactualizado.getVendedor());
        }

        // Guardar y devolver el producto actualizado en la base de datos
        return productoRepository.save(productoExistente);
    }
}
