package sample.demo.webservices.rest.services;

import sample.demo.database.jpa.SampleTest;

import java.util.List;

/**
 * @author pkumar on 4/12/17
 * @project javaEESamples
 */
public interface SampleTestService {

    SampleTest findById(Integer id);

    SampleTest findByName(String name);

    List<SampleTest> findAll();

    void saveSampleTest(SampleTest sampleTest);

    void updateSampleTest(SampleTest sampleTest);
}
