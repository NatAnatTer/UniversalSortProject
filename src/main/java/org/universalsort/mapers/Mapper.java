package org.universalsort.mapers;

import org.universalsort.model.UserClass;

import java.util.List;

public interface Mapper {
    List<? extends UserClass> map(List<String> list);
}
