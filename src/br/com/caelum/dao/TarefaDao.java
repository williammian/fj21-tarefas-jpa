package br.com.caelum.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.modelo.Tarefa;

@Repository
public class TarefaDao{
	
	@PersistenceContext
	private EntityManager manager;
		
	public void adiciona(Tarefa tarefa){
		manager.persist(tarefa);
	}
	
	public List<Tarefa> getLista(){
		return manager.createQuery("select t from Tarefa t").getResultList();
	}
	
	public Tarefa buscaPorId(Long id){
		return manager.find(Tarefa.class, id);
	}
	
	public void remove(Tarefa tarefa){
		Tarefa tarefaARemover = buscaPorId(tarefa.getId());
		manager.remove(tarefaARemover);
	}
	
	public void altera(Tarefa tarefa){
		manager.merge(tarefa);
	}
	
	public void finaliza(Long id){
		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(new Date());
		manager.merge(tarefa);
	}
	
}
