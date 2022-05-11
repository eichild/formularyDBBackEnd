package com.api.formularyDB.repositories;

import com.api.formularyDB.models.BancoDeDadosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BancoDeDadosRepository extends JpaRepository<BancoDeDadosModel, Integer> {
}
