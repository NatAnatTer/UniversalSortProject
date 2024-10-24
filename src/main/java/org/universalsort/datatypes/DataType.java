package org.universalsort.datatypes;

import org.universalsort.datatypes.creators.Creator;
import org.universalsort.model.UserClass;

import java.util.ArrayList;
import java.util.List;

public abstract class DataType {

    abstract public void printFiledOrder();

    abstract public Class getCurrentClass();

    abstract public String getDescription();
}