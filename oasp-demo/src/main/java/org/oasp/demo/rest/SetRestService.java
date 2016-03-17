package org.oasp.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.oasp.demo.service.SetService;
import org.oasp.demo.to.SetTo;
import org.oasp.demo.to.WantedSetTo;

import java.util.Collection;

@RequestMapping("/services")
@RestController
public class SetRestService {

    private final SetService setService;

    @Autowired
    public SetRestService(SetService setService) {
        this.setService = setService;
    }

    @RequestMapping(value = "/sets/owned", method = RequestMethod.GET)
    @ResponseBody
    public Collection<SetTo> findOwnedSets() {
        return setService.findOwnedSets();
    }

    @RequestMapping(value = "/sets/wanted/add", method = RequestMethod.POST)
    @ResponseBody
    public void addWantedSet(@RequestBody WantedSetTo wantedSetTo) {
        setService.addWantedSet(wantedSetTo);
    }

    @RequestMapping(value = "/sets/wanted", method = RequestMethod.GET)
    @ResponseBody
    public Collection<SetTo> findWantedSets() {
        return setService.findWantedSets();
    }
}
