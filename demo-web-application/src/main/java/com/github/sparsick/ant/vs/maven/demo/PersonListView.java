package com.github.sparsick.ant.vs.maven.demo;

import java.util.List;

import com.github.sparsick.ant.vs.maven.demo.domain.Person;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

final class PersonListView extends ListView<Person> {

    /**  */
    private static final long serialVersionUID = 9172837350405031400L;


    PersonListView(String id, List<? extends Person> list) {
        super(id, list);
    }


    @Override
    protected void populateItem(ListItem<Person> item) {
      Person person = item.getModelObject();
      item.add(new Label("firstname", person.getFirstName()));
      item.add(new Label("lastname", person.getLastName()));
      item.add(new Label("jobtitle", person.getJobTitle()));
    }
}