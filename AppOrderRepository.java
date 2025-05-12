package com.db.zepto.db_api.repository;

import com.db.zepto.db_api.model.AppOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppOrderRepository extends JpaRepository<AppOrder, UUID> {


}
