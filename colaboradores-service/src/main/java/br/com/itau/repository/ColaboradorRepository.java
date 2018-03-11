package br.com.itau.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.itau.model.ColaboradorModel;

public interface ColaboradorRepository extends Repository<ColaboradorModel, Integer>{

	void save(ColaboradorModel pessoa);
	 
	void delete(ColaboradorModel pessoa);
 
	List<ColaboradorModel> findAll();
 
	ColaboradorModel findOne(Integer id);
}
