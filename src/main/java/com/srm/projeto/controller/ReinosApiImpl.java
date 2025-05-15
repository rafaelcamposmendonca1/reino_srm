package com.srm.projeto.controller;

import com.srm.projeto.api.ReinosApi;
import com.srm.projeto.model.ReinoOutput;
import com.srm.projeto.service.ReinoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class ReinosApiImpl implements ReinosApi {

    private final ReinoService reinoService;

    @Override
    public ResponseEntity<List<ReinoOutput>> _reinosGet() {
        return new ResponseEntity<>(reinoService.findAll() ,OK);
    }
}
