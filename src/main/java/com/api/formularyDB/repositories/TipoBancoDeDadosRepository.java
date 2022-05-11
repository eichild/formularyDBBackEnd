package com.api.formularyDB.repositories;

import com.api.formularyDB.models.TipoBancoDeDadosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoBancoDeDadosRepository extends JpaRepository<TipoBancoDeDadosModel, Integer> {
}
