package unah.edu.lenguajes1700.proyecto.Service;

import java.util.List;

import unah.edu.lenguajes1700.proyecto.Entities.Categoria;

public interface CategoriaService {

    public Categoria agregarCategoria(Categoria categoria);

    public Categoria actualizarCategoria(int idcategoria, Categoria categoriaactualizada);

    public void eliminarCategoria(int idcategoria);

    public Categoria obtenerCategoriaPorId(int idcategoria);

    public List<Categoria> obtenerTodasLasCategorias();
}
