package com.mildw.minsu.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperUtils {
    private static ModelMapper modelMapper = initModelMapper();

    private static ModelMapper initModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
