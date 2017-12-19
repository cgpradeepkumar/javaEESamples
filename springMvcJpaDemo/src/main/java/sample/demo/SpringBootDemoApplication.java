package sample.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.demo.database.jpa.SampleTest;
import sample.demo.database.repository.RoleRepository;
import sample.demo.database.repository.SampleTestRepository;

/**
 * Created by pkumar on 29/6/17.
 */

@SpringBootApplication
public class SpringBootDemoApplication /*implements CommandLineRunner*/ {

    @Autowired
    DataSource dataSource;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SampleTestRepository sampleTestRepository;


/*    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("Datasource [" + dataSource + "]");

        *//*for(Role role: roleRepository.findAll()) {
            System.out.println("role Id [" + role.getRoleId() + "], DisplayName [" + role.getDisplayName() + "], Desc [" + role.getDescription() + "]");
        }*//*

        for (SampleTest sampleTest : sampleTestRepository.findAll()) {
            System.out.println("tech Id [" + sampleTest.getTechId() + "], tech name [" + sampleTest.getTechName() + "], tech desc [" + sampleTest.getTechDesc() + "], tech type [" + sampleTest.getTechType() + "], provider [" + sampleTest.getProvider() + "]");
        }

        System.out.println("------- DONE! -----------");
        System.out.println("--------------------------------------------------");

    }*/

    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
//        SpringApplication.run(SpringBootDemoApplication.class, args);
        app.run("");
    }
}
