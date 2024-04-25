package unah.edu.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1700.proyecto.Entities.Vendedor;
import unah.edu.lenguajes1700.proyecto.Service.Impl.VendedorServiceImpl;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorServiceImpl vendedorServiceImpl;

    @PostMapping("/registro")
    public Vendedor registrarNuevoVendedor(@RequestBody Vendedor vendedor) {
        return vendedorServiceImpl.registrarNuevoVendedor(vendedor);
    }

    @PostMapping("/autenticacion")
    public Vendedor autenticarVendedor(@RequestParam String correoelectronico, @RequestParam String contrasena) {
        return vendedorServiceImpl.autenticarVendedor(correoelectronico, contrasena);
    }

    @GetMapping("/obtener/{idvendedor}")
    public Vendedor obtenerVendedorPorId(@PathVariable int idvendedor) {
        return vendedorServiceImpl.obtenerVendedorPorId(idvendedor);
    }

    @GetMapping("/todos")
    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorServiceImpl.obtenerTodosLosVendedores();
    }

    @PutMapping("/actualizar/{idvendedor}")
    public void actualizarVendedor(@PathVariable int idvendedor, @RequestBody Vendedor vendedor) {
        vendedorServiceImpl.actualizarVendedor(idvendedor, vendedor);
    }

    @DeleteMapping("/eliminar/{idvendedor}")
    public void eliminarVendedor(@PathVariable int idvendedor) {
        vendedorServiceImpl.eliminarVendedor(idvendedor);
    }
}
