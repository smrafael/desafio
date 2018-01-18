package com.rafaelsm.desafio.repositories.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.rafaelsm.desafio.models.Client;

public class ClientSpecificationBuilder {
	
	private final List<SearchCriteria> params;
	 
    public ClientSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
    
    /**
     * Instantiate a builder based in a searchQuery
     *
     * @param searchQuery      Search query with a format "field1:value1,field2:value2"
     * @return the ClientSpecificationBuilder object
     */
    public ClientSpecificationBuilder(String searchQuery) {
    	this();
    	
    	if (searchQuery != null && !searchQuery.trim().isEmpty()) {
    		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)((\\w*\\s*)+),");
    		Matcher matcher = pattern.matcher(searchQuery + ",");
    		while (matcher.find()) {
    			matcher.group(1);
    			matcher.group(2);
    			matcher.group(3);
    			this.with(matcher.group(1), matcher.group(2), matcher.group(3));
    		}
    	}
    }
 
    public ClientSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<Client> build() {
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
	
}
