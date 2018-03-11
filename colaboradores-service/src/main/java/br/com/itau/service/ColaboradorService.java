package br.com.itau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.model.ColaboradorModel;
import br.com.itau.model.ResponseModel;
import br.com.itau.repository.ColaboradorRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")

public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository pessoaRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody ColaboradorModel pessoa){
 
 
		try {
 
			this.pessoaRepository.save(pessoa);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody ColaboradorModel pessoa){
 
		try {
 
			this.pessoaRepository.save(pessoa);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<ColaboradorModel> consultar(){
 
		return this.pessoaRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ColaboradorModel buscar(@PathVariable("codigo") Integer codigo){
 
		return this.pessoaRepository.findOne(codigo);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
 
		ColaboradorModel pessoaModel = pessoaRepository.findOne(codigo);
 
		try {
 
			pessoaRepository.delete(pessoaModel);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	

}
