package com.vcx.api.repository;

import com.vcx.api.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(nativeQuery = true, value="select c.* from company c", countQuery = "select c.* from company c")
    Page<Company> searchAll(Pageable pageable);
}
