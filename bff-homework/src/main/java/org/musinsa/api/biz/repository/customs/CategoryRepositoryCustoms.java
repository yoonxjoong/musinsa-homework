package org.musinsa.api.biz.repository.customs;

import org.musinsa.api.biz.entity.Category;

import java.util.Optional;

public interface CategoryRepositoryCustoms {
     Optional<Category> findByName(String name);
}
