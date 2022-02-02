package com.dxc.learning.demo1.repository;

import com.dxc.learning.demo1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
