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

import unah.edu.lenguajes1700.proyecto.Entities.Comprador;
import unah.edu.lenguajes1700.proyecto.Service.Impl.CompradorServiceImpl;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController {

    @Autowired
    private CompradorServiceImpl compradorServiceImpl;

    @PostMapping("/registro")
    public Comprador registrarNuevoComprador(@RequestBody Comprador comprador) {
        return compradorServiceImpl.registrarNuevoComprador(comprador);
    }

    @PostMapping("/autenticar")
    public Comprador autenticarComprador(@RequestParam String correoelectronico, @RequestParam String contrasena) {
        return compradorServiceImpl.autenticarComprador(correoelectronico, contrasena);
    }

    @GetMapping("obtener/{idcomprador}")
    public Comprador obtenerCompradorPorId(@PathVariable int idcomprador) {
        return compradorServiceImpl.obtenerCompradorPorId(idcomprador);
    }

    @GetMapping("/todos")
    public List<Comprador> obtenerTodosLosCompradores() {
        return compradorServiceImpl.obtenerTodosLosCompradores();
    }

    @PutMapping("actualizar/{idcomprador}")
    public void actualizarComprador(@PathVariable int idcomprador, @RequestBody Comprador comprador) {
        compradorServiceImpl.actualizarComprador(idcomprador, comprador);
    }

    @DeleteMapping("eliminar/{idcomprador}")
    public void eliminarComprador(@PathVariable int idcomprador) {
        compradorServiceImpl.eliminarComprador(idcomprador);
    }
}
