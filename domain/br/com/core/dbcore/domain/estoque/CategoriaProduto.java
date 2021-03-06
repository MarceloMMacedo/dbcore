package br.com.core.dbcore.domain.estoque;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.core.dbcore.domain.financeiro.contrato.Contrato;
import br.com.core.dbcore.domain.intefaces.BaseEntity;
import br.com.core.dbcore.domain.pessoas.Empresas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity 
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CategoriaProduto implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(columnDefinition = " int")
	@JsonIgnore
	private Empresas empresa;

	 
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<Produto> produto;
}
