package unah.edu.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1700.proyecto.Entities.DetalleFactura;
import unah.edu.lenguajes1700.proyecto.Entities.Facturacion;
import unah.edu.lenguajes1700.proyecto.Service.Impl.FacturacionServiceImpl;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionServiceImpl facturacionServiceImpl;

    @GetMapping("/{idfactura}")
    public Facturacion obtenerFacturaPorId(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerFacturaPorId(idfactura);
    }

    @GetMapping("/{idfactura}/detalles")
    public List<DetalleFactura> obtenerDetallesFactura(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerDetallesFactura(idfactura);
    }
}
