package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.domain.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(exported = false)
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Brand entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Brand> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
