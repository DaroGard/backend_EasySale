package unah.edu.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1700.proyecto.Entities.TarjetaComprador;
import unah.edu.lenguajes1700.proyecto.Service.Impl.TarjetaCompradorServiceImpl;

@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaCompradorController {

    @Autowired
    private TarjetaCompradorServiceImpl tarjetaCompradorServiceImpl;

    @PostMapping("/agregar")
    public TarjetaComprador agregarTarjetaComprador(@RequestBody TarjetaComprador tarjetacomprador) {
        return tarjetaCompradorServiceImpl.agregarTarjeta(tarjetacomprador);
    }

    @GetMapping("obtener/{idtarjetacomprador}")
    public TarjetaComprador obtenerTarjetaCompradorPorId(@PathVariable int idtarjetacomprador) {
        return tarjetaCompradorServiceImpl.obtenerTarjetaPorId(idtarjetacomprador);
    }

    @GetMapping("/comprador/{idcomprador}")
    public List<TarjetaComprador> obtenerTarjetasPorComprador(@PathVariable int idcomprador) {
        return tarjetaCompradorServiceImpl.obtenerTarjetasPorComprador(idcomprador);
    }

    @PutMapping("/actualizar/{idtarjetacomprador}")
    public TarjetaComprador actualizarTarjetaComprador(@PathVariable int idtarjetacomprador,
            @RequestBody TarjetaComprador tarjetacompradoractualizada) {
        return tarjetaCompradorServiceImpl.actualizarTarjetaComprador(idtarjetacomprador, tarjetacompradoractualizada);
    }
}
