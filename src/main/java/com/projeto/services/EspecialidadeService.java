package com.projeto.services; 
  
import java.util.List; 
import java.util.Optional; 
  
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
  
import com.projeto.entities.Especialidade; 
import com.projeto.repository.EspecialidadeRepository; 
  
@Service 
public class EspecialidadeService { 
    private final EspecialidadeRepository especialidadeRepository; 
     
    @Autowired 
    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) { 
        this.especialidadeRepository = especialidadeRepository; 
    } 
  
    public List<Especialidade> getAllEspecialidades() { 
        return especialidadeRepository.findAll(); 
    } 
  
    public Especialidade getEspecialidadeById(Long id) { 
        Optional<Especialidade> especialidade = especialidadeRepository.findById(id); 
        return especialidade.orElse(null); 
    } 
    //Query Method 
    public List<Especialidade> buscarEspecialidadesPorRa(String ra) { 
        return especialidadeRepository.findByRa(ra);  
      } 
    //Query Method  
    public List<Especialidade> buscarEspecialidadesPorCidade(String cidade) { 
        return especialidadeRepository.findByCidade(cidade);  
      } 
  
    public Especialidade salvarEspecialidade(Especialidade especialidade) { 
        return especialidadeRepository.save(especialidade); 
    } 
  
    public Especialidade updateEspecialidade(Long id, Especialidade updatedEspecialidade) { 
        Optional<Especialidade> existingEspecialidade = especialidadeRepository.findById(id); 
        if (existingEspecialidade.isPresent()) { 
            updatedEspecialidade.setId(id); 
            return especialidadeRepository.save(updatedEspecialidade); 
        } 
        return null; 
    } 
  
    public boolean deleteEspecialidade(Long id) { 
        Optional<Especialidade> existingEspecialidade = especialidadeRepository.findById(id); 
        if (existingEspecialidade.isPresent()) { 
            especialidadeRepository.deleteById(id); 
            return true; 
        } 
        return false; 
    } 
} 