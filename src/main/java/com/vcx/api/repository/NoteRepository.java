package com.vcx.api.repository;

import com.vcx.api.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    @Query(nativeQuery = true, value="select c.* from note c", countQuery = "select c.* from note c")
    Page<Note> searchAll(Pageable pageable);

    @Query(nativeQuery = true, value="select c.* from note c where c.provider_id = :id",
            countQuery = "select c.* from note c where c.provider_id = :id")
    Page<Note> searchAllbyCompany(@Param("id") Long id, Pageable pageable);

}
