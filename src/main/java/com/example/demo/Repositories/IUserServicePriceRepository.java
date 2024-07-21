package com.example.demo.Repositories;

import com.example.demo.Entity.UseService;
import com.example.demo.dtos.UserServicePriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.Entity.Service;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserServicePriceRepository extends JpaRepository<UseService,Long> {
    @Query("SELECT new com.example.demo.dtos.UserServicePriceDto(u.id,u.userid,u.serviceid,s.servicename,sp.serviceprice,sp.usedtime,u.datecreate) " +
         "from UseService  u " +
         "Join Service s on u.serviceid = s.serviceid " +
         "join ServicePrice sp on s.serviceid = sp.serviceid " +
         "Where sp.serviceprice < :price"
    )
    List<UserServicePriceDto> findUserServicePrice(@Param("price") double price);
}
