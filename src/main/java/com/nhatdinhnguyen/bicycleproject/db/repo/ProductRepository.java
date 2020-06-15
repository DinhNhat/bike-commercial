package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.domain.Product;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
//    List<Product> findByBrand_Name(@Param("name") String name);
    List<Product> findByCategory_Id(@Param("id") int id);

    Page<Product> findByBrand_Name(@Param("name") String name, Pageable pageable);

    List<Product> findByListPriceBetween(@Param("firstPrice") Double firstPrice, @Param("secondPrice") Double secondPrice);
}
