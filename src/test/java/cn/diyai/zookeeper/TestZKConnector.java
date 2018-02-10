package cn.diyai.zookeeper;

import junit.framework.TestCase;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;

/**
 * Created by diyai on 2018/2/9.
 */
public class TestZKConnector extends TestCase {

    ZKConnector zkc = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        zkc = new ZKConnector();
    }

    public void testCreate() throws IOException, InterruptedException, KeeperException {
        String path = "/test";
        String data = "this is test znode";

        zkc.connect(Constant.CONNECTION_STRING);
        try {
            zkc.delete(path);
        } catch (Exception ex) {
            System.out.println("fail to delete:"+ex.getMessage());
        }

        // 创建znode
        zkc.create(path, data.getBytes());

        for (byte item : zkc.getData(path)) {
            System.out.print((char) item);
        }

//        assertEquals(new String(zkc.getData(path)),data);

        //this is test znode31,s{'world,'anyone}
        //crdwa = 31 转换成二进制就是11111
        for (ACL acl : zkc.getacl(path)) {
            System.out.println(acl.toString());
        }

        zkc.isExists(path);

        zkc.getChilds(path);

    }

    public void testClientCnxn() throws IOException{

        //Clientcnxn将客户端请求加入发送队列，等待sendThread发送。eventThread负责处理Server返回的WatchedEvent，回调注册的客户端事件接口处理函数。
        
        //sendPacket => 客户端调用SendThread的sendPacket方法发送数据
        
//        finishPacket => 接收到服务端的响应，唤醒等待响应的客户端线程。
// 如果客户端请求指定了Watcher，则同时生成WatchedEvent事件并放入事件队列，等待eventThread线程处理。
// 客户端请求在写操作的情况下，发送完命令给服务端后会阻塞等待服务端响应，当ClientCntx收到服务端响应后调用finishPacket方法，唤醒阻塞在该Packet的客户端，客户端至此收到响应。
//        String chrootPath = "";
//        HostProvider hostProvider =null;  可以连接的ZK服务器列表
//        int sessionTimeout = 300000;
//        ZooKeeper zooKeeper =null;
//        ClientWatchManager watcher = null;
//        ClientCnxnSocket clientCnxnSocket =null;
//        long sessionId = 0;
//        byte[] sessionPasswd = "123456".getBytes();
//        boolean canBeReadOnly = false;
//        ClientCnxn clientCnxn = new ClientCnxn(chrootPath, hostProvider, sessionTimeout, zooKeeper,
//                watcher, clientCnxnSocket, canBeReadOnly);

    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        zkc.close();
    }
}
