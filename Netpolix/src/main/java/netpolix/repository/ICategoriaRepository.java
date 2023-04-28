package netpolix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import netpolix.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
