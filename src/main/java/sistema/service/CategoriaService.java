package sistema.service;

import java.util.List;

import sistema.dao.CategoriaDAO;
import sistema.models.Categoria;

public class CategoriaService {

	CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	public Categoria salvar(Categoria categoria)
	{
		System.out.println("Saving user...");
		categoria = (Categoria) categoriaDAO.save(categoria);
		categoriaDAO.closeEntityManager();
		System.out.println("User saved successfully");
		return categoria;
	}
	
	public List<Categoria> getCategorias()
	{
		List<Categoria> list = categoriaDAO.getAll(Categoria.class);
		categoriaDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(Categoria categoria) {
		categoriaDAO.save(categoria);
		categoriaDAO.closeEntityManager();
	}
	
	public void remove(Categoria categoria) {
		categoria = (Categoria) categoriaDAO.getById(Categoria.class, categoria.getCodCategoria());
		categoriaDAO.remove(categoria);
		categoriaDAO.closeEntityManager();
	}

}
