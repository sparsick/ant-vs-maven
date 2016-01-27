package com.github.sparsick.ant.vs.maven.demo;

import org.apache.wicket.model.CompoundPropertyModel;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.github.sparsick.ant.vs.maven.demo.repository.PersonRepository;
import com.github.sparsick.ant.vs.maven.demo.domain.Person;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

public class NewPersonForm extends Form<Person> {

    @SpringBean
    private PersonRepository personRepository;

    public NewPersonForm(String id) {
        super(id, new CompoundPropertyModel<Person>(new Person()));
    }

    public NewPersonForm(String id, IModel<Person> model) {
        super(id, model);
        add(new TextField<String>("firstName"));
        add(new TextField<String>("lastName"));
        add(new TextField<String>("jobTitle"));
        add(new Button("submitButton"));

    }

    /**
     *     */
    private static final long serialVersionUID = -8916183430933475415L;

    @Override
    protected void onSubmit() {
        super.onSubmit();
        personRepository.save(getModelObject());
        setResponsePage(new HomePage(null));
    }

}
