package br.com.spring.jdev.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.jdev.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%") // LIKE é para pesquisar por partes, e usamos %?1% porque temos um parametro! o TRIM é para tira os espaços! UPPER é para colocar tudo em maiusculo 
	List<Usuario> buscarPorNome(String name);
}
