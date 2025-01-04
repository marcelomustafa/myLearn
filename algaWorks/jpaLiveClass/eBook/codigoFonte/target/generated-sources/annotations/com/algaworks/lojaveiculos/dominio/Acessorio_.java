package com.algaworks.lojaveiculos.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Acessorio.class)
public abstract class Acessorio_ {

	public static volatile SingularAttribute<Acessorio, Long> codigo;
	public static volatile SetAttribute<Acessorio, Veiculo> veiculos;
	public static volatile SingularAttribute<Acessorio, String> descricao;

	public static final String CODIGO = "codigo";
	public static final String VEICULOS = "veiculos";
	public static final String DESCRICAO = "descricao";

}

