package com.rafaelsm.desafio.repositories.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.rafaelsm.desafio.Constants;
import com.rafaelsm.desafio.models.Client;

public class ClientSpecification implements Specification<Client> {
	
	private SearchCriteria criteria;
	
	public ClientSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (criteria.getOperation().equalsIgnoreCase(Constants.EQUAL_OPERATOR_CRITERIA)) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return cb.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return cb.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
		return null;
	}
	
}
