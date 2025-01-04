package com.algaworks.lojaveiculos.dominio;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ extends com.algaworks.lojaveiculos.dominio.Pessoa_ {

	public static volatile SingularAttribute<Cliente, BigDecimal> rendaMensal;
	public static volatile SingularAttribute<Cliente, BigDecimal> limiteCredito;
	public static volatile SingularAttribute<Cliente, Boolean> bloqueado;

	public static final String RENDA_MENSAL = "rendaMensal";
	public static final String LIMITE_CREDITO = "limiteCredito";
	public static final String BLOQUEADO = "bloqueado";

}

