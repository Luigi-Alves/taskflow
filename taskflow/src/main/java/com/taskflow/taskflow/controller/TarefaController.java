package com.taskflow.taskflow.controller;
import com.taskflow.taskflow.model.Tarefa;
import com.taskflow.taskflow.service.TarefaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Tarefa> buscarID(@PathVariable Long id) {
        return tarefaService.buscarID(id);
    }

    @PutMapping("/{id}")
    public Optional<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void removerTarefa(@PathVariable Long id) {
        tarefaService.removerTarefa(id);
    }
}
