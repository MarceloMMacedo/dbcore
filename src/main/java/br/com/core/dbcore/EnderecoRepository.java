package br.com.core.dbcore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.core.dbcore.domain.pessoas.EnderecoFuncionarios;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoFuncionarios, Integer> {

}
