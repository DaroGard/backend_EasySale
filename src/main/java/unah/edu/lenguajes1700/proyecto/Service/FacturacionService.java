package unah.edu.lenguajes1700.proyecto.Service;

import java.util.List;

import unah.edu.lenguajes1700.proyecto.Entities.DetalleFactura;
import unah.edu.lenguajes1700.proyecto.Entities.Facturacion;

public interface FacturacionService {

    public Facturacion obtenerFacturaPorId(int idfactura);

    public List<DetalleFactura> obtenerDetallesFactura(int idfactura);
}
