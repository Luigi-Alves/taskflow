package com.taskflow.taskflow.controller;

import com.taskflow.taskflow.model.Tarefa;
import com.taskflow.taskflow.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//informa ao Spring que essa classe é um controlador da API.
@RestController
// Define esta classe como controladora REST e estabelece "/tarefas-" como caminho base da API.
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> buscarTarefas(){
        return tarefaService.buscarTarefas();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa novaTarefa){
        return tarefaService.salvarTarefa(novaTarefa);
    }
}
