package org.universalsort.datatypes;

import org.universalsort.model.RootCrop;

import java.util.ArrayList;
import java.util.List;

public class RootCropDataType extends DataType {

    List<String> fileds;

    public RootCropDataType() {
        this.fileds = new ArrayList<>();
        fileds.add("Тип");
        fileds.add("Вес");
        fileds.add("Цвет");
    }


    @Override
    public Class<RootCrop> getCurrentClass() {
        return RootCrop.class;
    }

    @Override
    public void printFiledOrder() {
        StringBuilder stringBuilder = new StringBuilder("Порядок полей для чтения:");
        for (String f : fileds) {
            stringBuilder.append(f + " ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    @Override
    public String getDescription() {
        return "Крупа";
    }
}