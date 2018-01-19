package com.rafaelsm.desafio.repositories.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import com.rafaelsm.desafio.models.Client;

@Component
public class ClientSpecificationBuilder {
	
	public Specification<Client> build(String searchQuery) {
		List<SearchCriteria> params = processSearchQuery(searchQuery);
		return build(params);
	}
	
	public Specification<Client> build(List<SearchCriteria> params) {
		if (params.size() == 0) {
			return null;
		}
		
		List<Specification<Client>> specs = new ArrayList<Specification<Client>>();
		for (SearchCriteria param : params) {
			specs.add(new ClientSpecification(param));
		}
		
		Specification<Client> result = specs.get(0);
		for (int i = 1; i < specs.size(); i++) {
			result = Specifications.where(result).and(specs.get(i));
		}
		return result;
	}
	
	private List<SearchCriteria> processSearchQuery(String searchQuery) {
		List<SearchCriteria> params = new ArrayList<>();
		if (searchQuery != null && !searchQuery.trim().isEmpty()) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)((\\w*\\s*)+),");
			Matcher matcher = pattern.matcher(searchQuery + ",");
			while (matcher.find()) {
				String key = matcher.group(1);
				String op = matcher.group(2);
				Object value = matcher.group(3);
				params.add(new SearchCriteria(key, op, value));
			}
		}
		return params;
	}
}
