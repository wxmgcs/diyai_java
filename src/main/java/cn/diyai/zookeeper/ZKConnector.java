package cn.diyai.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by diyai on 2018/2/9.
 */
public class ZKConnector {

    private ZooKeeper zk;
    private CountDownLatch downLatch = new CountDownLatch(1);

    private Watcher watcher = new Watcher() {
        public void process(WatchedEvent event) {
            System.out.println(event.toString());
            if(event.getState() == Event.KeeperState.SyncConnected){
                downLatch.countDown();
            }
        }
    };


    public ZooKeeper connect(String host, Watcher watcher)throws IOException,InterruptedException,KeeperException {
        //1)客户端发起命令请求
        //2)构造Packet，调用ClientCnxn的submitRequest方法。ClientCnxn的submitRequest方法调用queuePacket方法将Request放入outgoingQueue队列中，然后调用线程wait方法等待该Request从服务端获得响应为止。
        //3)ClientCnxnSocketNetty和ClientCnzx共享同一个outgoingQueue，ClientCnxnSocketNetty启动了发送守护进程，当outgoingQueue队列中有Request时，会自动将该Request发送给ZooKeeperServer。同时ClientCnxnSocketNetty启动接收线程实时接收ZooKeeperServer的返回数据，返回数据触发ClientCnxnSocketNetty中启动的ZKClientHandler的MessageReceived事件。
        //4)在MessageReceived事件中调用ClientCnxn中的SendThread的readResponse方法。
        //5)readResponse方法中最后调用finishPacket方法唤醒在该请求上wait的2）中的submitRequest方法。使得submitRequest方法返回到客户端。
       /// 6)客户端获得返回的命令执行结果。
        zk = new ZooKeeper(host, Constant.SESSION_TIMEOUT, watcher);
        return zk;

    }

    public ZooKeeper connect(String host)throws IOException,InterruptedException,KeeperException{
        zk = new ZooKeeper(host, Constant.SESSION_TIMEOUT, watcher);
        return zk;

    }

    public void update(String path,byte[] data) throws InterruptedException,KeeperException{
        //设置节点关联数据
        zk.setData(path,data,zk.exists(path,true).getVersion());

    }

    public byte[] getData(String path)throws InterruptedException,KeeperException{
        //获取节点关联数据
        return zk.getData(path,true,zk.exists(path,true));
    }

    public void setData(String path,byte[] data)throws InterruptedException,KeeperException{
        zk.setData(path,data,zk.exists(path,true).getVersion());

    }

    public boolean create(String path,byte[] data)throws InterruptedException,KeeperException{
        try {
            //create方法根据输入参数构造出CreateRequest包，然后通过submitRequest方法传递给服务端，
            // submitRequest方法将CreateRequest转换成Packet包并调用sendPacket方法将发送包放入队列，等待发送线程发送给服务端。
            //服务端响应完成后会将返回结果填充到CreateResponse实体中返回给客户端。
            zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            return true;
        }catch (Exception ex){
            if(ex.getMessage().contains("NodeExists")){
                return true;
            }
        }
        return false;
    }

    /**
     * 删除znode
     * @param path
     * @throws InterruptedException
     * @throws KeeperException
     */
    public void delete(String path)throws InterruptedException,KeeperException{
        List<String> children = zk.getChildren(path, false);
        for (String pathCd : children) {
            //获取父节点下面的子节点路径
            String newPath = "";
            //递归调用,判断是否是根节点
            if (path.equals("/")) {
                newPath = "/" + pathCd;
            } else {
                newPath = path + "/" + pathCd;
            }
            delete(newPath);
        }
        //删除节点,并过滤zookeeper节点和 /节点
        if (path != null && !path.trim().startsWith("/zookeeper") && !path.trim().equals("/")) {
            zk.delete(path, -1);
            //打印删除的节点路径
            System.out.println("被删除的节点为：" + path);
        }
    }

    public List<String> getChilds(String path)throws InterruptedException,KeeperException{
        //获取子节点路径列表
        return zk.getChildren(path,true);
    }

    public List<ACL> getacl(String path)throws InterruptedException,KeeperException{
        return zk.getACL(path,zk.exists(path,true));
    }

    public void close() throws InterruptedException{
        zk.close();
    }


    public void isExists(String path) throws InterruptedException,KeeperException{
        //判断节点是否存在，异步方式，并且在回调函数中触发事件观察者
        zk.exists(path,true);
    }

//    public void startWebServer() throws  ClassNotFoundException{
//        Class<?> jettyAdminServerC = Class.forName("org.apache.zookeeper.server.admin.JettyAdminServer");
//        object adminServer = jettyAdminServerC.getConstructor(null).newInstance();
//    }

}
