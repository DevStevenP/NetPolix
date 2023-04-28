package netpolix.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import netpolix.entity.Categoria;
import netpolix.repository.ICategoriaRepository;
import netpolix.services.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepository categoriaRepo;

	@Override
	public List<Categoria> busarTodas() {
		return (List<Categoria>) categoriaRepo.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		categoriaRepo.save(categoria);
		
	}

}
