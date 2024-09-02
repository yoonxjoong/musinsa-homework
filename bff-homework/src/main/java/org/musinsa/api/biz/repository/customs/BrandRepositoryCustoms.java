package org.musinsa.api.biz.repository.customs;

import org.musinsa.api.biz.entity.Brand;

import java.util.Optional;

public interface BrandRepositoryCustoms {
     Optional<Brand> findByName(String name);
}
