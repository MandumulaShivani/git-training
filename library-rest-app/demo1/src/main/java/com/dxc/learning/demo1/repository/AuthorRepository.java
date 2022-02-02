package com.dxc.learning.demo1.repository;

import com.dxc.learning.demo1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
