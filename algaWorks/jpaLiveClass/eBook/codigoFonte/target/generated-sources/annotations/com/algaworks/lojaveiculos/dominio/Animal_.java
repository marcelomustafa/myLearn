package com.algaworks.lojaveiculos.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, Long> codigo;
	public static volatile SingularAttribute<Animal, String> nome;
	public static volatile SingularAttribute<Animal, LocalDateTime> dataUltimaAtualizacao;
	public static volatile SingularAttribute<Animal, LocalDate> dataNascimento;

	public static final String CODIGO = "codigo";
	public static final String NOME = "nome";
	public static final String DATA_ULTIMA_ATUALIZACAO = "dataUltimaAtualizacao";
	public static final String DATA_NASCIMENTO = "dataNascimento";

}

