package com.renfa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.renfa.helper.JsonHelper;
import com.renfa.helper.OptionHelper;
import com.renfa.model.Option;

@CrossOrigin("*")
@Controller
@RequestMapping("/option/")
public class OptionController {

    @RequestMapping(value = "/{optionID}", method = RequestMethod.GET)
    @ResponseBody
    public String getOptionData(@PathVariable("optionID") String optionID) {
        String output = "";
        Option opt = OptionHelper.getOptionValue(optionID);
        try {
            output = JsonHelper.objectToString(opt);
        } catch (JsonProcessingException ex) {
            output = "{\"error\":\"Fail to load data\"}";
        }
        return output;
    }

}
