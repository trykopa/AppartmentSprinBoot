package ua.kiev.prog.TestApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.TestApp.model.App;
import ua.kiev.prog.TestApp.model.People;
import ua.kiev.prog.TestApp.repo.AppRepository;
import ua.kiev.prog.TestApp.repo.PeopleRepository;

import java.util.List;


@Service
public class PeopleService {
    @Autowired
    private AppRepository appRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public void addPeople(People people){
        peopleRepository.save(people);
    }

    @Transactional
    public void addPeople(App app, People people ){

    }

    @Transactional
    public void addApp(App app){
        appRepository.save(app);
    }

    @Transactional
    public void deleteApp(App app){
        appRepository.deleteAll();
    }

    @Transactional
    public void deletePeople(){
        peopleRepository.deleteAll();
    }

    @Transactional
    public void deleteApp(long[] idList) {
        for (long id : idList)
            peopleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<App> findApps(){
        return appRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<People> findPeople(){ return peopleRepository.findAll(); }

    @Transactional(readOnly = true)
    public List<App> findApps(Pageable pageable){
        return appRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public List<People> findPeopleByApp(App app){
        return peopleRepository.findByApp(app);
    }

    @Transactional
    public App findApp(long id){
        return appRepository.findById(id).get();
    }

}
