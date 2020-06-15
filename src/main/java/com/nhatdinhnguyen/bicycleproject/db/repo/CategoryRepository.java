package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
