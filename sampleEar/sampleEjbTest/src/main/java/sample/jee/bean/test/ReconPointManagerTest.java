package sample.jee.bean.test;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import sample.jee.bean.DistributionGroupingManager;
import sample.jee.bean.ReconPointManagerRemote;
import sample.jee.bean.jpa.*;
import sample.jee.bean.util.ServiceResolver;

import javax.naming.NamingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author pkumar on 19/12/17
 * @project javaEESamples
 */
public class ReconPointManagerTest extends TestCase {


    public void testFindAll() {
        try {
            ReconPointManagerRemote reconPointManagerRemote = ServiceResolver.getInstance().lookup(ReconPointManagerRemote.JNDI_NAME, ReconPointManagerRemote.class);
            Assert.assertNotNull(reconPointManagerRemote);

            /*List<ReconPoint> reconPointList = reconPointManagerRemote.findAll();
            Assert.assertNotNull(reconPointList);*/


            ReconPoint reconPoint = reconPointManagerRemote.find("AA4", new Integer(1));
            Assert.assertNotNull(reconPoint);

            Collection<ReconPointDistribution> reconPointDistributions = reconPoint.getReconPointDistributions();
            Assert.assertNotNull(reconPointDistributions);

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave() {
        ReconPointManagerRemote reconPointManagerRemote = null;
        try {
            reconPointManagerRemote = ServiceResolver.getInstance().lookup(ReconPointManagerRemote.JNDI_NAME, ReconPointManagerRemote.class);
            Assert.assertNotNull(reconPointManagerRemote);

            ReconPoint reconPoint = reconPointManagerRemote.find("INP", new Integer(1));
            Assert.assertNotNull(reconPoint);

            DistributionGroupingManager distributionGroupingManager = ServiceResolver.getInstance().lookup(DistributionGroupingManager.JNDI_NAME, DistributionGroupingManager.class);

            DistributionGrouping distributionGrouping = distributionGroupingManager.findDistributionGrouping("Bloemfontein");
            Assert.assertNotNull(distributionGrouping);

            DistributionGroupingHierarchy distributionGroupingHierarchy = distributionGroupingManager.findDistributionGroupingHierarchyByDistGroupingId(88L);
            Assert.assertNotNull(distributionGroupingHierarchy);

            ReconPointDistributionContact reconPointDistributionContact = new ReconPointDistributionContact(reconPoint.getPk().getGrpNo(), reconPoint.getPk().getRcpNo(), "ENY", 10008, 3193390);
//            reconPointDistributionContact.setDistributionGroupingHierarchy(distributionGroupingHierarchy);

            ReconPointDistribution reconPointDistribution = new ReconPointDistribution(reconPoint.getPk().getGrpNo(), reconPoint.getPk().getRcpNo(), "ENY", "EMAIL");
            reconPointDistribution.setModifyDate(new Timestamp(new Date().getTime()));
            reconPointDistribution.setModifyName("Pradeep");

            Collection<ReconPointDistributionContact> reconPointDistributionContacts = new ArrayList<ReconPointDistributionContact>();
            reconPointDistributionContacts.add(reconPointDistributionContact);
            reconPointDistribution.setReconPointDistributionContacts(reconPointDistributionContacts);
            reconPointDistributionContact.setReconPointDistribution(reconPointDistribution);

            Collection<ReconPointDistribution> reconPointDistributions = new ArrayList<ReconPointDistribution>();
            reconPointDistributions.add(reconPointDistribution);
            reconPoint.setReconPointDistributions(reconPointDistributions);

            ReconPoint reconPointNew = reconPointManagerRemote.save(reconPoint);

            Assert.assertNotNull(reconPointNew.getReconPointDistributions());

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
