package sample.demo.webservices.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.demo.database.jpa.SampleTest;
import sample.demo.database.repository.SampleTestRepository;

import java.util.List;

/**
 * @author pkumar on 4/12/17
 * @project javaEESamples
 */

@Service("sampleTestService")
@Transactional
public class SampleTestServiceImpl implements SampleTestService {

    @Autowired
    SampleTestRepository sampleTestRepository;

    @Override
    public SampleTest findById(Integer id) {
        return null;
    }

    @Override
    public SampleTest findByName(String name) {
        return null;
    }

    @Override
    public List<SampleTest> findAll() {
        return sampleTestRepository.findAll();
    }

    @Override
    public void saveSampleTest(SampleTest sampleTest) {
        sampleTestRepository.save(sampleTest);
    }

    @Override
    public void updateSampleTest(SampleTest sampleTest) {

    }
}
