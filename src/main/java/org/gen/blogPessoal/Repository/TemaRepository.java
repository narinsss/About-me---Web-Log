package org.gen.blogPessoal.Repository;

import java.util.List;

import org.gen.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByCategoriaContainingIgnoreCase(String categoria);

}
