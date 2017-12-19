package sample.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.demo.database.jpa.SampleTest;

import java.util.List;

/**
 * @author pkumar on 28/11/17
 * @project javaEESamples
 */
public interface SampleTestRepository extends JpaRepository<SampleTest, Integer> {
    @Override
    public List<SampleTest> findAll();

    SampleTest save(SampleTest sampleTest);
}
