package org.musinsa.api.biz.repository;

import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.repository.customs.BrandRepositoryCustoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, BrandRepositoryCustoms {
}
