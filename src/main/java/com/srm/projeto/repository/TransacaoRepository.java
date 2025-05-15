package com.srm.projeto.repository;

import com.srm.projeto.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query("SELECT t FROM Transacao t WHERE " +
            "(:moedaProdutoId IS NULL OR t.moedaProduto.id = :moedaProdutoId) AND " +
            "(:moedaTransacaoId IS NULL OR t.moedaTransacao.id = :moedaTransacaoId) AND " +
            "(:reinoTransacao IS NULL OR t.reinoTransacao.nome = :reinoTransacao) AND " +
            "(:dataInicio IS NULL OR t.dataTransacao >= :dataInicio) AND " +
            "(:dataFim IS NULL OR t.dataTransacao <= :dataFim)")
    List<Transacao> buscarComFiltros(
            @Param("moedaProdutoId") Long moedaProdutoId,
            @Param("moedaTransacaoId") Long moedaTransacaoId,
            @Param("reinoTransacao") String reinoTransacao,
            @Param("dataInicio") OffsetDateTime dataInicio,
            @Param("dataFim") OffsetDateTime dataFim);

}
