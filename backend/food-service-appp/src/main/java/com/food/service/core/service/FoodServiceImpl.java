package com.food.service.core.service;

import com.food.service.config.Translator;
import com.food.service.core.entity.FoodEntity;
import com.food.service.core.enums.Status;
import com.food.service.core.params.FoodParam;
import com.food.service.core.repository.FoodRepository;
import com.food.service.core.util.ParamAndEntityBuilder;
import com.food.service.errorhandler.ErrorCodes;
import com.food.service.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ParamAndEntityBuilder paramAndEntityBuilder;

    @Autowired
    private Translator translator;

    @Override
    public void addFood(FoodParam param) {
        FoodEntity foodEntity = paramAndEntityBuilder.foodParamToEntity(param);
        foodEntity.setCreated(new Date());
        foodEntity.setStatus(Status.ACTIVE);
        foodRepository.saveAndFlush(foodEntity);
    }

    @Override
    public List<FoodParam> getAll() throws ResourceNotFoundException {
        List<FoodParam> paramList;
        List<FoodEntity> entities = foodRepository.findAll();
        if(entities.isEmpty()) {
            throw new ResourceNotFoundException(ErrorCodes.Feature.AUTHOR_GET,
                    ErrorCodes.CODE.AUTHOR_NOT_FOUND, translator.toLocale(ErrorCodes.REASON_MAP.get(ErrorCodes.CODE.AUTHOR_NOT_FOUND)));
        }

        paramList = entities.stream()
                .filter(x -> x.getStatus().equals(Status.ACTIVE))
                .map(x -> paramAndEntityBuilder.foodEntityToParam(x))
                .collect(Collectors.toList());
        return paramList;
    }

    @Override
    public void updateFood(FoodParam requestToParam) {
        requestToParam.setStatus(Status.ACTIVE);
        foodRepository.saveAndFlush(paramAndEntityBuilder.foodParamToEntity(requestToParam));
    }

    @Override
    public FoodParam getOne(long id) throws ResourceNotFoundException {
        FoodEntity foodEntity = foodRepository.getOne(id);
        if(foodEntity == null || !foodEntity.getStatus().name().equals(Status.ACTIVE.name())){
            throw new ResourceNotFoundException(ErrorCodes.Feature.AUTHOR_GET,
                    ErrorCodes.CODE.AUTHOR_NOT_FOUND,translator.toLocale(ErrorCodes.REASON_MAP.get(ErrorCodes.CODE.AUTHOR_NOT_FOUND)));
        }
        return paramAndEntityBuilder.foodEntityToParam(foodEntity);
    }

    @Override
    public void delete(long id) throws ResourceNotFoundException {
        FoodEntity foodEntity = foodRepository.getOne(id);
        if(foodEntity != null) {
            foodEntity.setStatus(Status.DELETED);
            foodRepository.save(foodEntity);
        }
        else {
            throw new ResourceNotFoundException(ErrorCodes.Feature.AUTHOR_GET,
                    ErrorCodes.CODE.AUTHOR_NOT_FOUND,translator.toLocale(ErrorCodes.REASON_MAP.get(ErrorCodes.CODE.AUTHOR_NOT_FOUND)));
        }
    }
}
