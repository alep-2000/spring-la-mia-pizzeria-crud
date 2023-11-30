package org.java.spring.db.repo;

import org.java.spring.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class PizzaRepository {
	
	@Repository
	public interface BookRepository extends JpaRepository<Pizza, Integer> {

	}
}
