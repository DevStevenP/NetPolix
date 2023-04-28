package netpolix.services;

import java.util.List;

import netpolix.entity.Categoria;

public interface ICategoriaService {
	
	public List<Categoria> busarTodas();
	
	public void guardar(Categoria categoria);

}
