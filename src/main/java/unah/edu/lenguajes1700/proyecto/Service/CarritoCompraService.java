package unah.edu.lenguajes1700.proyecto.Service;

import java.util.List;

import unah.edu.lenguajes1700.proyecto.Entities.CarritoCompra;

public interface CarritoCompraService {

        public void agregarProductoAlCarrito(int idcomprador, int idproducto, int cantidad);

        public void eliminarProductoDelCarrito(int idcomprador, int idproducto);

        public void realizarPedido(int idcomprador);

        public List<CarritoCompra> obtenerProductosEnCarrito(int idcomprador);

        public void vaciarCarrito(int idcomprador);
}
