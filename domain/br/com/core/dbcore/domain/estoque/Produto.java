package br.com.core.dbcore.domain.estoque;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.core.dbcore.domain.intefaces.BaseEntity;
import br.com.core.dbcore.domain.pessoas.Empresas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Produto implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(columnDefinition = " int")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonIgnore
	private Empresas empresa;
	
	
	private String especificação;

	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate dataEntrada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = " int")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CategoriaProduto categoriaProduto;// = new CategoriaProduto();	

	private String tipo;// servico / produto
	
	@ManyToOne
	@JoinColumn(columnDefinition = " int")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Modelo modelo;

	private String nameComplemento;

	@Transient
	private String nameProduto;

	private double altura;

	private double lagura;

	private double comprimento;

	private double peso;

	private String avatar;

	 
	@Transient
	private String avatarView;

 
	private String unidadeProduto;

	private String CodBarra;
 

	private String status;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<FornecedorProduto> fornecedores;// = new ArrayList<FornecedorProduto>();

	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<ProdutoContrato> produtocontrato;

}
