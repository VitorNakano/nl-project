package br.com.nakano.repositories;


import br.com.nakano.domain.Chore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoreRepository extends JpaRepository<Chore, Integer> {

    List<Chore> findChoreByCategory(String category);

}
