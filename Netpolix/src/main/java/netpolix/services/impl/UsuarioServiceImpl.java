package netpolix.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import netpolix.entity.Usuario;
import netpolix.repository.IUsuarioRepository;
import netpolix.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public void create(Usuario usuario) {
		usuarioRepository.save(usuario);
	}


	@Override
	public List<Usuario> listar() {
		return (List<Usuario>)usuarioRepository.findAll();
	}



}
