package com.taskflow.taskflow.service;
import com.taskflow.taskflow.model.Tarefa;
import com.taskflow.taskflow.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    public List<Tarefa> buscarTarefas(){
            return tarefaRepository.findAll();
    }

    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }


    public Optional<Tarefa> buscarID(Long id) {
        return tarefaRepository.findById(id);
    }


    public Optional<Tarefa> atualizarTarefa(Long id, Tarefa tarefa) {
        return tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefa.getTitulo());
            tarefaExistente.setDescricao(tarefa.getDescricao());
            tarefaExistente.setStatus(tarefa.getStatus());
            tarefaExistente.setPrioridade(tarefa.getPrioridade());
            tarefaExistente.setPrazo(tarefa.getPrazo());

            return tarefaRepository.save(tarefaExistente);
        });
    }

    @Transactional
    public void removerTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
