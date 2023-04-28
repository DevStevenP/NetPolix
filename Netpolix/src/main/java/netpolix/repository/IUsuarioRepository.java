package netpolix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import netpolix.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByEmail(String email);
	
}
