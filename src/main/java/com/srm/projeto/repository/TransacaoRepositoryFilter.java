package com.srm.projeto.repository;

import com.srm.projeto.entity.Transacao;
import com.srm.projeto.mapper.TransacaoMapper;
import com.srm.projeto.model.TransacaoFiltroInput;
import com.srm.projeto.model.TransacaoOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TransacaoRepositoryFilter {

    private final TransacaoMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public List<TransacaoOutput> findWithFilter(TransacaoFiltroInput filtro) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT t FROM Transacao t ");
        jpql.append("WHERE 1=1 ");
        List<String> conditions = getStrings(filtro);
        if (!conditions.isEmpty()) {
            jpql.append("AND ").append(String.join(" AND ", conditions));
        }
        jpql.append(" ORDER BY t.dataTransacao DESC");

        Query query = entityManager.createQuery(jpql.toString());

        if (filtro.getMoedaProdutoId() != null) {
            query.setParameter("moedaProdutoId", filtro.getMoedaProdutoId());
        }
        if (filtro.getMoedaTransacaoId() != null) {
            query.setParameter("moedaTransacaoId", filtro.getMoedaTransacaoId());
        }
        if (filtro.getReinoTransacao() != null && !filtro.getReinoTransacao().isEmpty()) {
            query.setParameter("reinoTransacao", filtro.getReinoTransacao());
        }
        if (filtro.getDataTransacao() != null) {
            query.setParameter("dataTransacao", filtro.getDataTransacao());
        }
        List<Transacao> transacoes = query.getResultList();
        return mapper.transacaoListToTransacaoOutputList(transacoes);
    }

    private List<String> getStrings(TransacaoFiltroInput filtro) {
        List<String> conditions = new ArrayList<>();
        if (filtro.getMoedaProdutoId() != null) {
            conditions.add("t.moedaProduto.id = :moedaProdutoId");
        }
        if (filtro.getMoedaTransacaoId() != null) {
            conditions.add("t.moedaTransacao.id = :moedaTransacaoId");
        }
        if (filtro.getReinoTransacao() != null && !filtro.getReinoTransacao().isEmpty()) {
            conditions.add("t.reinoTransacao.nome = :reinoTransacao");
        }
        if (filtro.getDataTransacao() != null) {
            conditions.add("t.dataTransacao = :dataTransacao");
        }
        return conditions;
    }

}
