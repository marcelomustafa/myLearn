package com.algaworks.lojaveiculos.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, Long> codigo;
	public static volatile ListAttribute<Categoria, Produto> produtos;
	public static volatile SingularAttribute<Categoria, String> nome;

	public static final String CODIGO = "codigo";
	public static final String PRODUTOS = "produtos";
	public static final String NOME = "nome";

}

