package com.srm.projeto.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransacaoMapperHelper {
    public static LocalDateTime dateTimeNow() {
        return LocalDateTime.now();
    }
}
