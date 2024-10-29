package org.universalsort.service;

import org.universalsort.data.Repository;
import org.universalsort.datatypes.BookDataType;
import org.universalsort.datatypes.CarDataType;
import org.universalsort.datatypes.DataType;
import org.universalsort.datatypes.RootCropDataType;
import org.universalsort.mapers.BookMapper;
import org.universalsort.mapers.RootCropMapper;
import org.universalsort.model.UserClass;

import java.util.List;

public class MapperService {
    Repository repository;

    public MapperService(Repository repository) {
        this.repository = repository;
    }

//    public List<? extends UserClass> map(DataType dataType, List<String> list) {
//        if (dataType instanceof BookDataType) {
//            return new BookMapper(repository).map();
//        } else if (dataType instanceof CarDataType) {
//            return new CarMapper().map(list);
//        } else if (dataType instanceof RootCropDataType) {
//            return new RootCropMapper().map(list);
//        }
//        return null;
//    }
}
