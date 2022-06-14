package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddTestImageDao extends JpaRepository<Image, Long> {
}
