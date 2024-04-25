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
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1700.proyecto.Entities.Categoria;
import unah.edu.lenguajes1700.proyecto.Service.Impl.CategoriaServiceImpl;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    @PostMapping("/agregar")
    public Categoria agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaServiceImpl.agregarCategoria(categoria);
    }

    @PutMapping("/actualizar/{idcategoria}")
    public Categoria actualizarCategoria(@PathVariable int idcategoria, @RequestBody Categoria categoriaactualizada) {
        return categoriaServiceImpl.actualizarCategoria(idcategoria, categoriaactualizada);
    }

    @DeleteMapping("/eliminar/{idcategoria}")
    public void eliminarCategoria(@PathVariable int idcategoria) {
        categoriaServiceImpl.eliminarCategoria(idcategoria);
    }

    @GetMapping("obtener/{idcategoria}")
    public Categoria obtenerCategoriaPorId(@PathVariable int idcategoria) {
        return categoriaServiceImpl.obtenerCategoriaPorId(idcategoria);
    }

    @GetMapping("/todas")
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaServiceImpl.obtenerTodasLasCategorias();
    }
}
