package com.example.demo.repository;// src/main/java/com/hei/tsinjo/repository/HelpRepository.java

import com.example.demo.model.Help;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HelpRepository {
    private final List<Help> helps = new ArrayList<>();
    private int idCounter = 1;

    public Help save(Help help) {
        help.setId("help-" + idCounter++);
        helps.add(help);
        return help;
    }

    public List<Help> findAllByOrderByPaymentDateDesc() {
        return helps.stream()
                .sorted(Comparator.comparing(h -> h.getPayment().getDate(), Comparator.reverseOrder()))
                .toList();
    }
}