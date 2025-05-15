package com.srm.projeto.repository;

import com.srm.projeto.entity.TaxaCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaxaCambioRepository extends JpaRepository<TaxaCambio, Long> {
    @Query("SELECT t FROM TaxaCambio t WHERE t.moedaOrigem.id = :moedaOrigemId AND t.moedaDestino.id = :moedaDestinoId")
    Optional<TaxaCambio> findByMoedaOrigemAndMoedaDestino(
            @Param("moedaOrigemId") Long moedaOrigemId,
            @Param("moedaDestinoId") Long moedaDestinoId);

    @Query("SELECT t FROM TaxaCambio t WHERE t.moedaDestino.id = :moedaDestinoId AND t.moedaOrigem.id = :moedaOrigemId")
    Optional<TaxaCambio> findByMoedaDestinoAndMoedaOrigem(
            @Param("moedaOrigemId") Long moedaOrigemId,
            @Param("moedaDestinoId") Long moedaDestinoId);
}
