package unah.edu.lenguajes1700.proyecto.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1700.proyecto.Entities.Categoria;
import unah.edu.lenguajes1700.proyecto.Repository.CategoriaRepository;
import unah.edu.lenguajes1700.proyecto.Service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(int idcategoria, Categoria categoriaactualizada) {
        Categoria categoriaExistente = categoriaRepository.findById(idcategoria)
                .orElseThrow(() -> new RuntimeException("No se encontró la categoría con ID: " + idcategoria));

        // Actualizar los campos opcionales solo si se proporcionan en
        // categoriaActualizada
        if (categoriaactualizada.getNombrecategoria() != null) {
            categoriaExistente.setNombrecategoria(categoriaactualizada.getNombrecategoria());
        }

        // Guardar y devolver la categoría actualizada en la base de datos
        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void eliminarCategoria(int idcategoria) {
        categoriaRepository.deleteById(idcategoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(int idcategoria) {
        return categoriaRepository.findById(idcategoria).orElse(null);
    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }
}
