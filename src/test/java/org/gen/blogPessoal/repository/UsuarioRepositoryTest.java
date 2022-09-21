package org.gen.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.gen.blogPessoal.Repository.UsuarioRepository;
import org.gen.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //arquivo de teste
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L, "Julia Nun", "julia@gmail.com", "123456789", "https://oc-fanhub-assets.s3.amazonaws.com/img/avatar-jmg.png", null));
		usuarioRepository.save(new Usuario(0L, "Julio Nun", "julio@gmail.com", "1234560789", "https://pbs.twimg.com/profile_images/2068072926/julio_400x400.jpg", null));
		usuarioRepository.save(new Usuario(0L, "Julius Nun", "julius@gmail.com", "1234567009", "https://pbs.img.com/profile_images/2068072926/julio_400x400.jpg", null));
	
	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("julia@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("julia@gmail.com"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Nun");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Julia Nun"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Julio Nun"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Julius Nun"));
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}
