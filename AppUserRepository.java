package com.db.zepto.db_api.repository;

import com.db.zepto.db_api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    public AppUser findByEmail(String email);

    @Query(value = "select * from app_user where user_type='DELIVERY_PARTNER' and pincode=:pincode", nativeQuery = true)
    public List<AppUser> getDeliveryPartnerByPincode(int pincode);

}
