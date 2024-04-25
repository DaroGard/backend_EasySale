package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.DetalleFactura;
import unah.edu.lenguajes1700.proyecto.Entities.Facturacion;
import unah.edu.lenguajes1700.proyecto.Repository.DetalleFacturaRepository;
import unah.edu.lenguajes1700.proyecto.Repository.FacturacionRepository;
import unah.edu.lenguajes1700.proyecto.Service.FacturacionService;

@Service
public class FacturacionServiceImpl implements FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public Facturacion obtenerFacturaPorId(int idfactura) {
        // Obtener la factura por su ID
        return facturacionRepository.findById(idfactura).orElse(null);
    }

    @Override
    public List<DetalleFactura> obtenerDetallesFactura(int idfactura) {
        // Obtener los detalles de la factura por el ID de la factura
        return detalleFacturaRepository.findByFacturaIdfactura(idfactura);
    }
}
