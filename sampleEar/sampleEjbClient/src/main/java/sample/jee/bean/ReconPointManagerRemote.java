package sample.jee.bean;

import sample.jee.bean.jpa.ReconPoint;

import javax.ejb.Remote;
import java.util.List;

/**
 * @author pkumar on 18/12/17
 * @project javaEESamples
 */

@Remote
public interface ReconPointManagerRemote {

    public static final String JNDI_NAME = "sample/ReconPointManagerBean";

    public List<ReconPoint> findAll();

    public ReconPoint find(String grpNo, Integer rcpNo);

    public ReconPoint save(ReconPoint reconPoint);
}
