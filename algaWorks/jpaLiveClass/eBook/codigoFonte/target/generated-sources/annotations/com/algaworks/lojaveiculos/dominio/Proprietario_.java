package com.algaworks.lojaveiculos.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Proprietario.class)
public abstract class Proprietario_ {

	public static volatile SingularAttribute<Proprietario, Long> codigo;
	public static volatile ListAttribute<Proprietario, Veiculo> veiculos;
	public static volatile SingularAttribute<Proprietario, String> nome;
	public static volatile ListAttribute<Proprietario, Telefone> telefones;
	public static volatile SingularAttribute<Proprietario, String> email;

	public static final String CODIGO = "codigo";
	public static final String VEICULOS = "veiculos";
	public static final String NOME = "nome";
	public static final String TELEFONES = "telefones";
	public static final String EMAIL = "email";

}

