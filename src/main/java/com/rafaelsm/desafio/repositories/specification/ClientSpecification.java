package com.rafaelsm.desafio.repositories.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.rafaelsm.desafio.Constants;
import com.rafaelsm.desafio.models.Address;
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
		Predicate predicate = null;
		try {
			if (criteria.getOperation().equalsIgnoreCase(Constants.EQUAL_OPERATOR_CRITERIA)) {
				if (criteria.getKey().contains("address.")) {
					predicate = joinAddress(root, cb);
				
				} else if (criteria.getKey().equals("sexo")) {
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
	
	public Predicate joinAddress(Root<Client> root, CriteriaBuilder cb) {
		String key = criteria.getKey().replace("address.", "");
		Join<Client, Address> join = root.join("address");

		if (key.equals("estado")) {
			return cb.equal(join.get(key), Estado.valueOf(criteria.getValue().toString()));
		}
		
		if (join.get(key).getJavaType() == String.class) {
            return cb.like(join.<String>get(key), criteria.getValue() + "%");
        } else {
            return cb.equal(join.get(key), criteria.getValue());
        }
		
	}
	
}
