CREATE TABLE moeda (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    simbolo VARCHAR(10) NOT NULL,
    descricao TEXT
);
INSERT INTO moeda (nome, simbolo, descricao) VALUES
('Ouro Real', 'OR', 'Moeda da capital Real'),
('Tibar', 'TB', 'Moeda do reino dos anoes');

CREATE TABLE reino (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

INSERT INTO reino (nome, descricao) VALUES
('Tibar', 'Reino Tibar, conhecido por sua fortaleza'),
('Anoes', 'Reino Anoes, famoso por seus guerreiros');

CREATE TABLE taxa_cambio (
    id BIGSERIAL PRIMARY KEY,
    moeda_origem_id BIGINT NOT NULL,
    moeda_destino_id BIGINT NOT NULL,
    taxa DOUBLE PRECISION NOT NULL,
    data_vigencia TIMESTAMP NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_taxa_moeda_origem FOREIGN KEY (moeda_origem_id) REFERENCES moeda(id),
    CONSTRAINT fk_taxa_moeda_destino FOREIGN KEY (moeda_destino_id) REFERENCES moeda(id),
    CONSTRAINT uk_taxa_cambio_data UNIQUE (moeda_origem_id, moeda_destino_id, data_vigencia)
);

INSERT INTO taxa_cambio (moeda_origem_id, moeda_destino_id, taxa, data_vigencia, data_criacao) VALUES
(1, 2, 2.5, '2025-05-14 00:00:00', '2025-05-14 00:00:00'),
(2, 1, 0.4, '2025-05-14 00:00:00', '2025-05-14 00:00:00');

CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    qualidade VARCHAR(20) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reino_origem_id BIGINT NOT NULL,
    CONSTRAINT fk_produto_reino FOREIGN KEY (reino_origem_id) REFERENCES reino(id)
);

CREATE TABLE transacao (
    id BIGSERIAL PRIMARY KEY,
    produto_id BIGINT NOT NULL,
    quantidade INTEGER NOT NULL,
    moeda_produto_id BIGINT NOT NULL,
    moeda_transacao_id BIGINT NOT NULL,
    valor_original DOUBLE PRECISION NOT NULL,
    valor_convertido DOUBLE PRECISION NOT NULL,
    valor_total_convertido DOUBLE PRECISION NOT NULL,
    reino_transacao_id BIGINT NOT NULL,
    data_transacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transacao_produto FOREIGN KEY (produto_id) REFERENCES produto(id),
    CONSTRAINT fk_transacao_moeda_produto FOREIGN KEY (moeda_produto_id) REFERENCES moeda(id),
    CONSTRAINT fk_transacao_moeda_transacao FOREIGN KEY (moeda_transacao_id) REFERENCES moeda(id),
    CONSTRAINT fk_transacao_reino FOREIGN KEY (reino_transacao_id) REFERENCES reino(id)
);
