package com.rafaelsm.desafio.repositories.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.rafaelsm.desafio.Constants;
import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.models.Estado;
import com.rafaelsm.desafio.models.Sexo;

public class ClientSpecification implements Specification<Client> {
	
	private SearchCriteria criteria;
	
	public ClientSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (criteria.getOperation().equalsIgnoreCase(Constants.EQUAL_OPERATOR_CRITERIA)) {
			try {
				if (criteria.getKey().equals("sexo")) {
					return cb.equal(root.get(criteria.getKey()), Sexo.valueOf(criteria.getValue().toString()));
				}
				
				if (criteria.getKey().equals("estado")) {
					return cb.equal(root.get(criteria.getKey()), Estado.valueOf(criteria.getValue().toString()));
				}
			} catch (IllegalArgumentException ex) {
				return null;
			}
			
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return cb.like(root.<String>get(criteria.getKey()), criteria.getValue() + "%");
            } else {
                return cb.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
		return null;
	}
	
}
