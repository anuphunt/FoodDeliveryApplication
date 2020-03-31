package com.food.service.api.controller;

import com.food.service.api.model.FoodResource;
import com.food.service.api.validator.FoodRequestValidator;
import com.food.service.config.Translator;
import com.food.service.core.service.FoodService;
import com.food.service.errorhandler.ErrorCodes;
import com.food.service.errorhandler.ResourceNotFoundException;
import com.food.service.util.RequestAndParamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodEndPoint {

    @InitBinder("foodRequest")
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new FoodRequestValidator());
    }

    private static final Logger log = LoggerFactory.getLogger(FoodEndPoint.class);

    @Autowired
    private FoodService foodService;

    @Autowired
    private RequestAndParamBuilder requestAndParamBuilder;

    @Autowired
    private Translator translator;

    @GetMapping("/test")
    public String test() {
        return "Welcome to Food Service App";
    }

    @PostMapping
    public void add(@RequestBody @Valid FoodResource request) {
        log.info("Food adding api called");
        foodService.addFood(requestAndParamBuilder.requestToParam(request));
        log.info("Food added.");
    }

    @PutMapping("{id}")
    public void update(@RequestBody @Valid FoodResource request, @PathVariable long id) throws Exception {
        if (id <= 0) {
            log.error("No food found for this food id {}", id);
            throw new ResourceNotFoundException(ErrorCodes.Feature.AUTHOR_GET,
                    ErrorCodes.CODE.AUTHOR_NOT_FOUND, translator.toLocale(ErrorCodes.REASON_MAP.get(ErrorCodes.CODE.AUTHOR_NOT_FOUND)));
        }

        foodService.updateFood(requestAndParamBuilder.requestToParam(request));
    }

    @GetMapping
    public List<FoodResource> getAllFood() throws ResourceNotFoundException {
        log.info("Getting all active foods");
        List<FoodResource> foodResources =
                foodService.getAll().stream()
                        .map(foodParam -> requestAndParamBuilder.paramToRequest(foodParam))
                        .collect(Collectors.toList());

        return foodResources;
    }

    @GetMapping(value = "{id}")
    public FoodResource getOne(@PathVariable long id) throws ResourceNotFoundException {
        return requestAndParamBuilder.paramToRequest(foodService.getOne(id));
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable long id) throws ResourceNotFoundException {
        log.info("Food deleting for id {}", id);
        foodService.delete(id);
    }
}
