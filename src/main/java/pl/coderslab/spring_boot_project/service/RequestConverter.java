package pl.coderslab.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring_boot_project.model.Request;

public class RequestConverter implements Converter<String, Request> {

    @Autowired
    private RequestService requestService;

    @Override
    public Request convert(String s) {
        if(s==null ||s.isEmpty()){
            return null;
        }
        return requestService.findOne(Long.parseLong(s));
    }
}
