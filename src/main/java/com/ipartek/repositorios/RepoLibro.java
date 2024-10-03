package com.ipartek.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.modelo.Libro;

@Repository
public interface RepoLibro extends JpaRepository<Libro, Integer>{

}
