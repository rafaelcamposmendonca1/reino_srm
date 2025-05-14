CREATE TABLE moeda (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    simbolo VARCHAR(10) NOT NULL,
    descricao TEXT
);

CREATE TABLE taxa_cambio (
    id SERIAL PRIMARY KEY,
    moeda_origem_id INTEGER NOT NULL,
    moeda_destino_id INTEGER NOT NULL,
    taxa DECIMAL(19, 6) NOT NULL,
    data_vigencia DATE NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_moeda_origem FOREIGN KEY (moeda_origem_id) REFERENCES moeda(id),
    CONSTRAINT fk_moeda_destino FOREIGN KEY (moeda_destino_id) REFERENCES moeda(id),
    CONSTRAINT uk_taxa_cambio_data UNIQUE (moeda_origem_id, moeda_destino_id, data_vigencia)
);

CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    reino_origem VARCHAR(50) NOT NULL CHECK (reino_origem IN ('SRM', 'Anões')),
    preco_base DECIMAL(19, 6) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE taxa_especifica_produto (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER NOT NULL,
    moeda_origem_id INTEGER NOT NULL,
    moeda_destino_id INTEGER NOT NULL,
    fator_ajuste DECIMAL(19, 6) NOT NULL,
    formula_conversao TEXT,
    ativa BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto(id),
    CONSTRAINT fk_moeda_origem FOREIGN KEY (moeda_origem_id) REFERENCES moeda(id),
    CONSTRAINT fk_moeda_destino FOREIGN KEY (moeda_destino_id) REFERENCES moeda(id),
    CONSTRAINT uk_taxa_especifica UNIQUE (produto_id, moeda_origem_id, moeda_destino_id)
);

CREATE TABLE transacao (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER NOT NULL,
    moeda_origem_id INTEGER NOT NULL,
    moeda_destino_id INTEGER NOT NULL,
    valor_original DECIMAL(19, 6) NOT NULL,
    valor_convertido DECIMAL(19, 6) NOT NULL,
    taxa_utilizada DECIMAL(19, 6) NOT NULL,
    quantidade DECIMAL(19, 6) NOT NULL,
    reino_origem VARCHAR(50) NOT NULL CHECK (reino_origem IN ('SRM', 'Anões')),
    data_transacao TIMESTAMP NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto(id),
    CONSTRAINT fk_moeda_origem FOREIGN KEY (moeda_origem_id) REFERENCES moeda(id),
    CONSTRAINT fk_moeda_destino FOREIGN KEY (moeda_destino_id) REFERENCES moeda(id)
);

INSERT INTO moeda (id, nome, simbolo, descricao) VALUES
(1, 'Ouro Real', 'OR', 'Moeda oficial do Reino SRM'),
(2, 'Tibar', 'TB', 'Moeda dos anãos das montanhas');

INSERT INTO taxa_cambio (moeda_origem_id, moeda_destino_id, taxa, data_vigencia) VALUES
(1, 2, 2.5, CURRENT_DATE);

INSERT INTO taxa_cambio (moeda_origem_id, moeda_destino_id, taxa, data_vigencia) VALUES
(2, 1, 0.4, CURRENT_DATE);

INSERT INTO produto (nome, descricao, reino_origem, preco_base, ativo) VALUES
('Peles de Lobo', 'Peles de alt a qualidade dos lobos das montanhas', 'Anooes', 50.0, TRUE),
('Madeira de Carvalho', 'Madeira nobre das florestas de SRM', 'SRM', 30.0, TRUE),
('Hidromel Especial', 'Bebida fermentada de mel, especialidade dos anãos', 'Anões', 15.0, TRUE);