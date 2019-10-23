package io.github.brfreitas.shouldideploytoday.service;

import io.github.brfreitas.shouldideploytoday.model.Reason;
import io.github.brfreitas.shouldideploytoday.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReasonService {

    private final ReasonRepository repository;

    @Autowired
    public ReasonService(ReasonRepository repository) {
        this.repository = repository;
    }

    public Optional<Reason> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Reason> findRandom(){
        return repository.findRandom();
    }

    public Reason create(Reason reason){
        return repository.save(reason);
    }
}
