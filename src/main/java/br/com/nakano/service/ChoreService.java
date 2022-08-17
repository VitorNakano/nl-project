package br.com.nakano.service;

import br.com.nakano.domain.Chore;
import br.com.nakano.repositories.ChoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChoreService {

    @Autowired
    private ChoreRepository choreRepository;

    public void createChore(String choreName, String category, boolean isDeadline,
                            LocalDate deadline, String detail) throws Exception{
        checkValues(choreName, category);
        if(isDeadline){
            choreRepository.save(new Chore(choreName, category, detail));
        } else {
            choreRepository.save(new Chore(choreName, category, deadline, detail));
        }
    }

    public List<Chore> listAllChores(){
        return choreRepository.findAll();
    }

    public List<Chore> listByCategory(String category){
        return choreRepository.findChoreByCategory(category);
    }

    public void removeChore(Integer id) {
        choreRepository.deleteById(id);
    }

    public void changeExistingChore(Integer id, String choreName, String category,
                                    String detail, boolean isDeadline, LocalDate deadline) {
        Chore chore = addChoreInfos(id, choreName, category, detail, isDeadline, deadline);
        choreRepository.save(chore);
    }

    private void checkValues(String valOne, String valTwo) throws Exception {
        if(valOne.isEmpty() || valTwo.isEmpty()) throw new Exception("Chore or Category is Empty!");
    }

    public Chore addChoreInfos(Integer id, String choreName, String category, String detail,
                               boolean isDeadline, LocalDate deadline) {
        Chore chore = choreRepository.getReferenceById(id);
        chore.setChoreName(choreName);
        chore.setCategory(category);
        chore.setDetail(detail);
        if(isDeadline) {
          chore.setDeadline(deadline);
        }
        return chore;
    }
}
