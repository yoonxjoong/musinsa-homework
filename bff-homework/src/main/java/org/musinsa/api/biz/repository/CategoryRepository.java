package org.musinsa.api.biz.repository;

import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.repository.customs.CategoryRepositoryCustoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustoms {
}
