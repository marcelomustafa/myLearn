package com.algaworks.lojaveiculos.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Veiculo.class)
public abstract class Veiculo_ {

	public static volatile SingularAttribute<Veiculo, Long> codigo;
	public static volatile SingularAttribute<Veiculo, TipoCombustivel> tipoCombustivel;
	public static volatile SingularAttribute<Veiculo, byte[]> foto;
	public static volatile SingularAttribute<Veiculo, Proprietario> proprietario;
	public static volatile SingularAttribute<Veiculo, String> especificacoes;
	public static volatile SingularAttribute<Veiculo, BigDecimal> valor;
	public static volatile SingularAttribute<Veiculo, Integer> anoFabricacao;
	public static volatile SetAttribute<Veiculo, Acessorio> acessorios;
	public static volatile SingularAttribute<Veiculo, String> fabricante;
	public static volatile SingularAttribute<Veiculo, Integer> anoModelo;
	public static volatile SingularAttribute<Veiculo, String> modelo;
	public static volatile SingularAttribute<Veiculo, LocalDate> dataCadastro;

	public static final String CODIGO = "codigo";
	public static final String TIPO_COMBUSTIVEL = "tipoCombustivel";
	public static final String FOTO = "foto";
	public static final String PROPRIETARIO = "proprietario";
	public static final String ESPECIFICACOES = "especificacoes";
	public static final String VALOR = "valor";
	public static final String ANO_FABRICACAO = "anoFabricacao";
	public static final String ACESSORIOS = "acessorios";
	public static final String FABRICANTE = "fabricante";
	public static final String ANO_MODELO = "anoModelo";
	public static final String MODELO = "modelo";
	public static final String DATA_CADASTRO = "dataCadastro";

}

