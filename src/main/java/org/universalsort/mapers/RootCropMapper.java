package org.universalsort.mapers;

import org.universalsort.data.Repository;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class RootCropMapper implements Mapper {

    Repository repository;
    public RootCropMapper(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void map() {
        List<RootCrop> rootCrops = new ArrayList<>();
        List<String > list = (List<String>) repository.getInputCollection();
        for (String s : list) {
            String[] fields = Validator.convertString(s);
            RootCrop rootCrop = RootCrop.builder()
                    .type(fields[0])
                    .weight(Validator.returnDoubleValue(fields[1]))
                    .color(fields[2]).build();
            rootCrops.add(rootCrop);
        }
        repository.saveRootCropCollections(rootCrops);
    }
}