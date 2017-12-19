package sample.demo.webservices.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.demo.database.jpa.SampleTest;
import sample.demo.webservices.rest.services.SampleTestService;

import java.util.List;

/**
 * @author pkumar on 4/12/17
 * @project javaEESamples
 */

@RestController
@RequestMapping("/sample-test")
public class SampleTestRestController {

    @Autowired
    SampleTestService sampleTestService;

    @RequestMapping(value = "/listAll/", method = RequestMethod.GET)
    public ResponseEntity<List<SampleTest>> listAll() {
        List<SampleTest> list = sampleTestService.findAll();
        if(list.isEmpty()) {
            return new ResponseEntity<List<SampleTest>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<SampleTest>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/createSampleTest/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> createSampleTest(@RequestBody SampleTest sampleTest) {

        sampleTestService.saveSampleTest(sampleTest);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
