package org.universalsort.mapers;

import org.universalsort.model.RootCrop;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class RootCropMapper implements Mapper {
    @Override
    public List<RootCrop> map(List<String> list) {
        List<RootCrop> rootCrops = new ArrayList<>();
        for (String s : list) {
            String[] fields = Validator.convertString(s);
            RootCrop rootCrop = RootCrop.builder()
                    .type(fields[0])
                    .weight(Validator.returnDoubleValue(fields[1]))
                    .color(fields[2]).build();
            rootCrops.add(rootCrop);
        }
        return rootCrops;
    }
}