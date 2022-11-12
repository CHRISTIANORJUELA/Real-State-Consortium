package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.DTOs.Name;
import org.jetbrains.annotations.NotNull;

public class Comparator {
    public int compareTo(Object ob1, Object ob2) {
        return ((Name)ob1).getNamePerson().compareTo(((Name) ob2).getNamePerson());
    }

}
