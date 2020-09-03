package app.service;

import app.entity.Configuration;
import app.repositories.CRUDInterface;
import app.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService implements CRUDInterface<Configuration> {

    @Autowired
    ConfigurationRepository repository;

    @Override
    public void save(Configuration configuration) {
        repository.save(configuration);
    }

    @Override
    public Configuration findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Configuration> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Configuration configuration) {
        repository.delete(configuration);
    }

    public HttpStatus saveFlow(Configuration configuration) {
        return HttpStatus.OK;
    }

    public HttpStatus deleteFlow(long id) {
        delete(findById(id));
        return HttpStatus.OK;
    }
}
