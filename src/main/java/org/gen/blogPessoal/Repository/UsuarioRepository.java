package org.gen.blogPessoal.Repository;

import java.util.List;
import java.util.Optional;

import org.gen.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(@Param("user") String usuario);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(@Param(" nome") String nome);
}
