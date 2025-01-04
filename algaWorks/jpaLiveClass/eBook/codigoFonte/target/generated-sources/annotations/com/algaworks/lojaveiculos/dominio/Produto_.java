package com.algaworks.lojaveiculos.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Long> codigo;
	public static volatile SingularAttribute<Produto, Categoria> categoria;
	public static volatile SingularAttribute<Produto, String> nome;

	public static final String CODIGO = "codigo";
	public static final String CATEGORIA = "categoria";
	public static final String NOME = "nome";

}

