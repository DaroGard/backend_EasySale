package unah.edu.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1700.proyecto.Entities.CarritoCompra;
import unah.edu.lenguajes1700.proyecto.Service.Impl.CarritoCompraServiceImpl;

@RestController
@RequestMapping("/api/carritocompra")
public class CarritoCompraController {

    @Autowired
    private CarritoCompraServiceImpl carritoCompraServiceImpl;

    @PostMapping("/agregarproducto")
    public void agregarProductoAlCarrito(@RequestParam int idcomprador, @RequestParam int idproducto,
            @RequestParam int cantidad) {
        carritoCompraServiceImpl.agregarProductoAlCarrito(idcomprador, idproducto, cantidad);
    }

    @DeleteMapping("/eliminarproducto")
    public void eliminarProductoDelCarrito(@RequestParam int idcomprador, @RequestParam int idproducto) {
        carritoCompraServiceImpl.eliminarProductoDelCarrito(idcomprador, idproducto);
    }

    @GetMapping("/productos/{idcomprador}")
    public List<CarritoCompra> obtenerProductosEnCarrito(@PathVariable int idcomprador) {
        return carritoCompraServiceImpl.obtenerProductosEnCarrito(idcomprador);
    }

    @DeleteMapping("/vaciarcarrito/{idcomprador}")
    public void vaciarCarrito(@PathVariable int idcomprador) {
        carritoCompraServiceImpl.vaciarCarrito(idcomprador);
    }

    @PostMapping("/realizarpedido/{idcomprador}")
    public void realizarPedido(@PathVariable int idcomprador) {
        carritoCompraServiceImpl.realizarPedido(idcomprador);
    }
}
