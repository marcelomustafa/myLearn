package com.algaworks.lojaveiculos.dominio;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ extends com.algaworks.lojaveiculos.dominio.Pessoa_ {

	public static volatile SingularAttribute<Funcionario, BigDecimal> salario;
	public static volatile SingularAttribute<Funcionario, String> cargo;

	public static final String SALARIO = "salario";
	public static final String CARGO = "cargo";

}

