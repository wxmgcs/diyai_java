package cn.diyai.datastructures.linklist;

/**
 * 单向链表
 * @author wangxiaomin
 *
 */
public class ListNode {

	private int data;
	private ListNode next;

	public ListNode(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getNext() {
		return this.next;
	}

	/**
	 * 链表的长度
	 * 
	 * @param headNode
	 * @return
	 */
	int listLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	/**
	 * 单向链表的插入
	 * @param headNode
	 * @param nodeToInsert
	 * @param position
	 * @return
	 */
	ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
		if (headNode == null) {
			return nodeToInsert;
		}

		int size = listLength(headNode);
		if (position > size + 1 || position < 1) {
			System.out.println("posistion of node to insert is invalid." + "The valid inputs are 1 tp " + (size + 1));
			return headNode;
		}

		if (position == 1) {// 在链表开头插入
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {
			// 在链表中间或末尾插入
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}

			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}

		return headNode;
	}
	
	/**
	 * 删除单向链表
	 * @param head
	 */
	void DeleteLinkedList(ListNode head){
		ListNode auxilaryNode ,iterator = head;
		while(iterator != null){
			auxilaryNode = iterator.getNext();
			iterator = null;
			iterator = auxilaryNode;
		}
	}

	private int getLinkedListLength(ListNode headNode){
		return 0;
	}

	
	/**
	 * 删除单向链表中间的一个结点
	 * @param headNode
	 * @param position
	 * @return
	 */
	ListNode DeleteNodeFromLinkedList(ListNode headNode,int position){
		int size = getLinkedListLength(headNode);
		if(position > size || position < 1){
			System.out.println("posistion of node to insert is invalid." + "The valid inputs are 1 tp "+size);
			return headNode;
		}
		
		if (position == 1){
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}else{
			ListNode previousNode = headNode;
			int count =1;
			while(count < position){
				previousNode = previousNode.getNext();
				count++;
			}
			
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		
		return headNode;
	}
	
	
	boolean DoesLinkedListContainsLoop(ListNode head){
		if (head ==null){
			return false;
		}
		ListNode slowPtr = head,fastPtr = head;
		while(fastPtr.getNext() != null && fastPtr.getNext().getNext() != null){
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr == fastPtr){
				return true;
			}
		}
		return false;
	}
	
	int findBeginofLoop(ListNode head){

		return 0;
	}
	
	
	int findLoopLength(ListNode head){
		return 0;
	}
	
	ListNode insertInSortedList(ListNode head,ListNode newNode){
		return null;
	}
	
	ListNode reverseList(ListNode head){
		return null;
	}
	
	
	ListNode findIntersectingNode(ListNode list1,ListNode list2){
		return null;
	}
	
	ListNode findMiddle(ListNode head){
		return null;
	}
	
	ListNode mergeList(ListNode a,ListNode b){
		return null;
	}
	
	void splitList(ListNode head,ListNode head1,ListNode head2){
	}
	
	void exchangeAdijacentNodes(ListNode head){
		
	}
	
	ListNode getKPlusOneTHNode(int K,ListNode head){
		//@todo
		return head.getNext();
	}
	
	
	
	
	
}
