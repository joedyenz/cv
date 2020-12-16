package com.cv.configuration;

import com.cv.model.CVModel;
import com.cv.domain.CVDTO;
import lombok.SneakyThrows;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;

@Component
public class OrikaConfiguration extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory){ mapperFactoryClass(factory);}

    public MapperFactory mapperFactoryClass(MapperFactory mapperFactory){

        mapperFactory.classMap(CVModel.class, CVDTO.class).byDefault().register();
        mapperFactory.classMap(CVDTO.class, CVModel.class).byDefault().register();

        return mapperFactory;
    }
}
