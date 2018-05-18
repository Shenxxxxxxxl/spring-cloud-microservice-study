package com.itmuch.cloud.base.repository;

import com.itmuch.cloud.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository  extends JpaRepository<BaseEntity,Long> {
}
