package com.algaworks.lojaveiculos.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Telefone.class)
public abstract class Telefone_ {

	public static volatile SingularAttribute<Telefone, String> numero;
	public static volatile SingularAttribute<Telefone, String> prefixo;
	public static volatile SingularAttribute<Telefone, String> ramal;

	public static final String NUMERO = "numero";
	public static final String PREFIXO = "prefixo";
	public static final String RAMAL = "ramal";

}

