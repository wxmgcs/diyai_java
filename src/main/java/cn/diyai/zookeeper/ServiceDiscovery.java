package cn.diyai.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import static cn.diyai.zookeeper.Constant.CONNECTION_STRING;

/**
 *
 * 服务发现,监控znode的变化
 *
 * 1.*
 */
public class ServiceDiscovery {
    private ZooKeeper zooKeeper;
    private boolean monitoring;
    private CountDownLatch downLatch = new CountDownLatch(1);
    ZKConnector zkc= null;

    public ServiceDiscovery() throws IOException,InterruptedException,KeeperException {
        zkc = new ZKConnector();
        zooKeeper = zkc.connect(CONNECTION_STRING,watcher);
    }

    private Watcher watcher = new Watcher() {
        public void process(WatchedEvent event) {
            if(event.getState() == Event.KeeperState.SyncConnected && ! monitoring){
                watchServiceZnode();
                monitoring = true;
            }

            if(event.getType() == Event.EventType.NodeChildrenChanged){
                watchServiceZnode();
                System.out.println(1);
            }
        }
    };

    private void watchServiceZnode(){
        try {
            List<String> serviceList = zooKeeper.getChildren("/", watcher);
            for (String service : serviceList){
                System.out.println(service);
            }
            System.out.println("================");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException,KeeperException {

        new ServiceDiscovery();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入'quit'结束程序:");
        while (true){
            String commond = scanner.nextLine();
            if(commond.equalsIgnoreCase("quit")){
                System.out.println("bye!");
                break;
            }
            System.out.println(">>" + commond);
        }
    }
}
