package cn.diyai.leetcode;

public class ListNodeDemo {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {


        return head;
    }

    public static void main(String[] args){

        ListNodeDemo listNodeDemo = new ListNodeDemo();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode  listNode = listNodeDemo.sortList(listNode1);

    }

}
