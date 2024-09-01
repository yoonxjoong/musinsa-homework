package org.musinsa.api.biz.repository;

import org.musinsa.api.biz.entity.Commodity;
import org.musinsa.api.biz.repository.customs.CommodityRepositoryCustoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, UUID>, CommodityRepositoryCustoms {
}
