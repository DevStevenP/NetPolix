package netpolix.services;


import java.util.List;
import netpolix.entity.Usuario;


public interface IUsuarioService {

	public void create(Usuario usuario);
	
	public List<Usuario> listar();
	
}
