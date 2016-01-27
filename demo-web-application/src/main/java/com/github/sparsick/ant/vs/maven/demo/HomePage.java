package com.github.sparsick.ant.vs.maven.demo;

import com.github.sparsick.ant.vs.maven.demo.domain.Person;
import com.github.sparsick.ant.vs.maven.demo.repository.PersonRepository;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private PersonRepository personRepository;


    public HomePage(final PageParameters parameters) {
        super(parameters);

        add(new PersonListView("personList", personRepository.findAllPersons()));

        add(new NewPersonForm("newPersonForm", new CompoundPropertyModel<Person>(new Person())));

    }
}
