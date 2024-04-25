package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.CarritoCompra;
import unah.edu.lenguajes1700.proyecto.Entities.Comprador;
import unah.edu.lenguajes1700.proyecto.Entities.DetalleFactura;
import unah.edu.lenguajes1700.proyecto.Entities.Facturacion;
import unah.edu.lenguajes1700.proyecto.Entities.Producto;
import unah.edu.lenguajes1700.proyecto.Repository.CarritoCompraRepository;
import unah.edu.lenguajes1700.proyecto.Repository.CompradorRepository;
import unah.edu.lenguajes1700.proyecto.Repository.DetalleFacturaRepository;
import unah.edu.lenguajes1700.proyecto.Repository.FacturacionRepository;
import unah.edu.lenguajes1700.proyecto.Repository.ProductoRepository;
import unah.edu.lenguajes1700.proyecto.Service.CarritoCompraService;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraService {

    @Autowired
    private CarritoCompraRepository carritoCompraRepository;

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FacturacionRepository facturacionRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public void realizarPedido(int idComprador) {
        // Obtener el comprador
        Comprador comprador = compradorRepository.findById(idComprador).orElse(null);
        if (comprador == null) {
            throw new RuntimeException("No se encontró el comprador con ID: " + idComprador);
        } else {
            // Obtener todos los carritos de compras del comprador
            List<CarritoCompra> carritos = carritoCompraRepository.findByCompradorIdcomprador(idComprador);
            if (carritos.isEmpty()) {
                throw new RuntimeException("El comprador no tiene ningún carrito de compras");
            }
            // Iterar sobre todos los carritos de compras del comprador
            for (CarritoCompra carrito : carritos) {
                // Calcular el total de la factura y crear la instancia de Facturacion
                BigDecimal totalFactura = carrito.getProducto().stream()
                        .map(producto -> producto.getPrecio()
                                .multiply(BigDecimal.valueOf(producto.getCantidadproducto())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                Facturacion factura = new Facturacion();
                factura.setCarritocompra(carrito);
                factura.setFechafacturacion(LocalDate.now());
                factura.setTotal(totalFactura);

                // Crear detalles de factura y actualizar la cantidad de productos
                List<DetalleFactura> detallesFactura = carrito.getProducto().stream()
                        .map(producto -> {
                            // Verificar si hay suficiente cantidad disponible para cada producto
                            if (producto.getCantidadproducto() < producto.getCantidadproducto()) {
                                throw new RuntimeException("No hay suficiente cantidad disponible para el producto: "
                                        + producto.getNombre());
                            }
                            DetalleFactura detalle = new DetalleFactura();
                            detalle.setFactura(factura);
                            detalle.setProducto(producto);
                            detalle.setCantidad(producto.getCantidadproducto());
                            detalle.setSubtotal(
                                    producto.getPrecio().multiply(BigDecimal.valueOf(producto.getCantidadproducto())));
                            // Actualizar la cantidad disponible en el producto
                            producto.setCantidadproducto(
                                    producto.getCantidadproducto() - producto.getCantidadproducto());
                            return detalle;
                        })
                        .collect(Collectors.toList());

                // Guardar la factura y los detalles de factura
                facturacionRepository.save(factura);
                detalleFacturaRepository.saveAll(detallesFactura);

                // Actualizar el estado del carrito de compras a "pagado"
                carrito.setEstado("pagado");
                carritoCompraRepository.save(carrito);
            }
        }
    }

    @Override
    public void agregarProductoAlCarrito(int idcomprador, int idproducto, int cantidad) {
        // Verificar si el producto existe
        Producto producto = productoRepository.findById(idproducto)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));

        // Obtener el carrito de compras del comprador
        List<CarritoCompra> carritos = carritoCompraRepository.findByCompradorIdcomprador(idcomprador);

        CarritoCompra carrito;
        if (carritos.isEmpty()) {
            carrito = new CarritoCompra();
            carrito.setComprador(compradorRepository.findById(idcomprador)
                    .orElseThrow(() -> new RuntimeException("No se encontró el comprador con ID: " + idcomprador)));
        } else {
            carrito = carritos.get(0);
        }

        // Agregar el producto al carrito o actualizar la cantidad si ya existe
        List<Producto> productosEnCarrito = carrito.getProducto();
        boolean productoEncontrado = false;
        for (Producto p : productosEnCarrito) {
            if (p.getIdproducto() == idproducto) {
                // Actualizar la cantidad si el producto ya está en el carrito
                p.setCantidadproducto(p.getCantidadproducto() + cantidad);
                productoEncontrado = true;
                break;
            }
        }
        if (!productoEncontrado) {
            // Agregar el producto al carrito si no está presente
            producto.setCantidadproducto(cantidad);
            productosEnCarrito.add(producto);
        }

        // Actualizar el carrito de compras en la base de datos
        carrito.setProducto(productosEnCarrito);
        carritoCompraRepository.save(carrito);
    }

    @Override
    public void eliminarProductoDelCarrito(int idcomprador, int idproducto) {
        // Obtener el carrito de compras del comprador
        List<CarritoCompra> carritos = carritoCompraRepository.findByCompradorIdcomprador(idcomprador);
        if (carritos.isEmpty()) {
            throw new RuntimeException("No se encontró el carrito de compras para el comprador con ID: " + idcomprador);
        }
        CarritoCompra carrito = carritos.get(0);

        // Eliminar el producto del carrito si está presente
        List<Producto> productosEnCarrito = carrito.getProducto();
        productosEnCarrito.removeIf(p -> p.getIdproducto() == idproducto);

        // Actualizar el carrito de compras en la base de datos
        carrito.setProducto(productosEnCarrito);
        carritoCompraRepository.save(carrito);
    }

    @Override
    public List<CarritoCompra> obtenerProductosEnCarrito(int idcomprador) {
        // Obtener el carrito de compras del comprador
        List<CarritoCompra> carritos = carritoCompraRepository.findByCompradorIdcomprador(idcomprador);
        if (carritos.isEmpty()) {
            throw new RuntimeException("No se encontró el carrito de compras para el comprador con ID: " + idcomprador);
        }
        return carritos;
    }

    @Override
    public void vaciarCarrito(int idcomprador) {
        // Obtener el carrito de compras del comprador
        List<CarritoCompra> carritos = carritoCompraRepository.findByCompradorIdcomprador(idcomprador);
        if (carritos.isEmpty()) {
            throw new RuntimeException("No se encontró el carrito de compras para el comprador con ID: " + idcomprador);
        }
        CarritoCompra carrito = carritos.get(0);

        // Limpiar la lista de productos en el carrito
        carrito.getProducto().clear();

        // Actualizar el carrito de compras en la base de datos
        carritoCompraRepository.save(carrito);
    }

}
