package unah.edu.lenguajes1700.proyecto.Service;

import java.util.List;

import unah.edu.lenguajes1700.proyecto.Entities.Producto;

public interface ProductoService {

    public Producto guardarProducto(Producto producto);

    public Producto obtenerProductoPorId(int idproducto);

    public List<Producto> obtenerTodosProductos();

    public void eliminarProducto(int idproducto);

    public Producto actualizarProducto(int idproducto, Producto productoactualizado);
}
