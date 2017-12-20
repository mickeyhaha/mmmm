package com.holo.utils;

import org.I0Itec.zkclient.IZkDataListener;
import org.apache.zookeeper.CreateMode;
import static org.junit.Assert.assertTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

/**
 * Test on local:
 * 1. download zookeeper: https://zookeeper.apache.org/
 * 2. go to conf/, mv zoo_sample.cfg zoo.cfg
 * 3. go to bin/, run ./zkServer.sh start
 * 4. run ZkUtilsTest (update HoneyBadger/pom.xml, update <skipTests>false</skipTests> to <skipTests>true</skipTests>)
 * 
 * @author jason
 */
public class ZkUtilsTest {

    protected static final Logger LOG = LoggerFactory.getLogger(ZkUtilsTest.class);

    @Test
    public void test() throws Exception {
        String zkAddress = "127.0.0.1:2181";
        String path      = "/testgroup/DFP/GatherScripts";
        String value     = "{this is a script}";
        ZkUtils.createNode(zkAddress, "/testgroup/DFP/GatherScripts", value, CreateMode.PERSISTENT);
        
        assertTrue(ZkUtils.exist(zkAddress, path));
        assertTrue(value.equals(ZkUtils.getData(zkAddress, path)));
        
        ZkUtils.getZKClient(zkAddress).subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println(dataPath + " changed to: " + data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println(dataPath + " deleted");
            }
        });
        
        ZkUtils.setData(zkAddress, path, "new value:" + value);
        ZkUtils.deleteNode(zkAddress, path, true);     
        
        Thread.sleep(5000);
    }
}
