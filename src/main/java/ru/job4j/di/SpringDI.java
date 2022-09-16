package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();

        StartUI ui = context.getBean(StartUI.class);
        ConsoleInput input = context.getBean(ConsoleInput.class);

        input.askStr("Is this a Spring application context?");
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();

        StartUI secondUi = context.getBean(StartUI.class);
        secondUi.add("Person from second store");
        secondUi.add("Person2 from second store");
        secondUi.print();

        context.close();
    }
}
