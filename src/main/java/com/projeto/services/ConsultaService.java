package com.projeto.services;  
   
import java.util.List;  
import java.util.Optional;  
   
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
   
import com.projeto.entities.Consulta;  
import com.projeto.repository.ConsultaRepository;    
    
@Service    
public class ConsultaService {    
	private final ConsultaRepository consultaRepository;      
	@Autowired      
	public ConsultaService(ConsultaRepository consultaRepository) {      
		this.consultaRepository = consultaRepository;      
	}     
	public List<Consulta> buscaTodosConsultas() {      
		return consultaRepository.findAll();     
	}     
	public Consulta buscaConsultaId(Long id) {      
		Optional <Consulta> consulta = consultaRepository.findById(id);     
		return consulta.orElse(null);     
	}     
	public List<Consulta> buscarConsultasPorData(String data){ 
		return consultaRepository.findByData(data); 
	} 
	public List<Consulta> buscarConsultasPorHora(double hora){ 
		return consultaRepository.findByHora(hora); 
	} 
	public List<Consulta> buscarConsultasPorPet(String pet){ 
		return consultaRepository.findByPet(pet); 
	} 
	public List<Consulta> buscarConsultasPorVeterinario(String veterinario){ 
		return consultaRepository.findByVeterinario(veterinario); 
	} 
	public Consulta salvaConsulta(Consulta consulta) {      
		return consultaRepository.save(consulta);      
	}     
	public Consulta alterarConsulta(Long id, Consulta alterarUser) {      
		Optional <Consulta> existeConsulta = consultaRepository.findById(id);      
		if (existeConsulta.isPresent()) {      
			alterarUser.setId(id);      
			return consultaRepository.save(alterarUser);      
		}     
		return null;      
	}     
	public boolean apagarConsulta(Long id) {     
		Optional <Consulta> existeConsulta = consultaRepository.findById(id);      
		if (existeConsulta.isPresent()) {      
			consultaRepository.deleteById(id);      
			return true;      
		}    
		return false;      
	}    
} 