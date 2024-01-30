package com.test.repository;

import com.test.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> getAllByDeletedIsFalse();

    Boolean existsByTitle(String title);

    Category getById(Long id);

    Optional<Category> findByTitle(String title);
}
