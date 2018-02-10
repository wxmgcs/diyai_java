package cn.diyai.zookeeper;


import org.apache.zookeeper.*;

import java.io.IOException;

import static com.ctu.zookeeper.Constant.CONNECTION_STRING;
import static com.ctu.zookeeper.Constant.CONNECTION_TIMEOUT;

/**
 * @author zhaojh.
 */
public class BasicOperationForClient {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(CONNECTION_STRING, CONNECTION_TIMEOUT, new Watcher() {
            public void process(org.apache.zookeeper.WatchedEvent event) {
               String message = String.format("已经触发了[%s]事件。节点:[%s]", event.getType(), event.getWrapper().getPath());
               System.out.println(message);
            }
        });

        zk.create("/quick4j", "quick4j".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //取"/quick4j"节点
        System.out.println("节点[/quick4j]数据: " + new String(zk.getData("/quick4j", true, null)));


        zk.create("/quick4j/upm", "upm".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //取"/quick4j"子节点
        System.out.println("节点[/quick4j]子节点： " + zk.getChildren("/quick4j", true));
        System.out.println("节点[/quick4j/upm]数据：" + new String(zk.getData("/quick4j/upm", true, null)));


        //修改"/quick4j/upm"节点
        zk.setData("/quick4j/upm", "quick4j-upm".getBytes(), -1);
        //获取"/quick4j"节点状态
        System.out.println("节点[/quick4j/upm]状态：[" + zk.exists("/quick4j/upm", true) + "]");

        //创建"/quick4j"的另一个子节点"dws"
        zk.create("/quick4j/dws", "quick4j-dws".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //获取"/quick4j/quick4j-dws"节点数据
        System.out.println("节点[/quick4j/dws]数据： " + new String(zk.getData("/quick4j/dws", true, null)));

        //取"/quick4j"子节点
        System.out.println("节点[/quick4j]子节点： " + zk.getChildren("/quick4j", true));

        //删除子节点
        zk.delete("/quick4j/upm", -1);
        zk.delete("/quick4j/dws", -1);


        //删除父节点
        zk.delete("/quick4j", -1);
        zk.close();
    }
}
