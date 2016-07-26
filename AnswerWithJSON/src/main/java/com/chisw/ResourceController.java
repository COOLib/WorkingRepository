package com.chisw;

import com.chisw.model.MyResource;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourceController {

    private List<MyResource> resourceList = new ArrayList<>();

    private void filling() {

        resourceList.add(new MyResource(1,"Ruslan", "Kulib"));
        resourceList.add(new MyResource(2,"Ruslan1", "Kulib1"));
        resourceList.add(new MyResource(3,"Ruslan2", "Kulib2"));
    }

    @RequestMapping(value="/getresource/{id}", method = RequestMethod.GET)
    public MyResource getSomeResource(@PathVariable("id") String id) {

        if (resourceList.isEmpty()) filling();
        MyResource resource = resourceList.get(Integer.parseInt(id));
        return resource;
    }

    @RequestMapping(value="/getresources", method = RequestMethod.GET)
    public List<MyResource> getResources() {

        if (resourceList.isEmpty()) filling();
        return resourceList;
    }

    @RequestMapping(value="/postresource", method = RequestMethod.POST)
    public @ResponseBody MyResource addResource() {

        if (resourceList.isEmpty()) filling();
        MyResource resource1 = new MyResource(4,"Ruslan3", "Kulib3");
        resourceList.add(resource1);
        return resource1;
    }

    @RequestMapping(value="/postresource/{id}", method = RequestMethod.PUT)
    public @ResponseBody MyResource updateResource(@PathVariable("id") String id) {

        if (resourceList.isEmpty()) filling();
        MyResource myResource = resourceList.get(Integer.parseInt(id));
        myResource.setId(6);
        myResource.setContentName("AnotherRuslan");
        resourceList.set(Integer.parseInt(id), myResource);
        return myResource;
    }

    @RequestMapping(value="/postresource/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteResource( @PathVariable("id") String id) {

        if (resourceList.isEmpty()) filling();
        resourceList.remove(Integer.parseInt(id));
    }
}