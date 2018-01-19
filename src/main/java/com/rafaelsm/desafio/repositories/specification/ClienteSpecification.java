package com.rafaelsm.desafio.repositories.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.rafaelsm.desafio.models.Cliente;
import com.rafaelsm.desafio.models.Endereco;
import com.rafaelsm.desafio.models.Estado;
import com.rafaelsm.desafio.models.Sexo;

public class ClienteSpecification implements Specification<Cliente> {
	
	private static final String ADDRESS_FIELD_NAME= "address";
	private static final String ADDRESS_ESTADO_NAME= "estado";
	private static final String CLIENT_SEXO_NAME= "sexo";
	private static final String ADDRESS_JOIN = ADDRESS_FIELD_NAME + ".";
	
	private static final String EQUAL_OPERATOR_CRITERIA = ":";
	
	private SearchCriteria criteria;
	
	public ClienteSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate predicate = null;
		try {
			if (criteria.getOperation().equalsIgnoreCase(EQUAL_OPERATOR_CRITERIA)) {
				if (criteria.getKey().contains(ADDRESS_JOIN)) {
					predicate = joinAddress(root, cb);
				
				} else if (criteria.getKey().equals(CLIENT_SEXO_NAME)) {
					predicate =  cb.equal(root.get(criteria.getKey()), Sexo.valueOf(criteria.getValue().toString()));
				
				} else if (root.get(criteria.getKey()).getJavaType() == String.class) {
					predicate =  cb.like(root.<String>get(criteria.getKey()), criteria.getValue() + "%");
				} else {
					predicate =  cb.equal(root.get(criteria.getKey()), criteria.getValue());
				}
			}
		} catch (IllegalArgumentException ex) {
			predicate = null;
		}
		return predicate;
	}
	
	public Predicate joinAddress(Root<Cliente> root, CriteriaBuilder cb) {
		String key = criteria.getKey().replace(ADDRESS_JOIN, "");
		Join<Cliente, Endereco> join = root.join(ADDRESS_FIELD_NAME);

		if (key.equals(ADDRESS_ESTADO_NAME)) {
			return cb.equal(join.get(key), Estado.valueOf(criteria.getValue().toString()));
		}
		
		if (join.get(key).getJavaType() == String.class) {
            return cb.like(join.<String>get(key), criteria.getValue() + "%");
        } else {
            return cb.equal(join.get(key), criteria.getValue());
        }
		
	}
	
}
