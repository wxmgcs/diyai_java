package cn.diyai.datastructures.linklist;
/**
 * 双向链表
 * @author wangxiaomin
 *
 */
public class DLLNode {

	private int data;
	private DLLNode next;
	private DLLNode previous;

	public DLLNode(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}

	public int getData() {
		return data;
	}

	public DLLNode getNext() {
		return next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	/**
	 * 双向链表的中间插入一个结点
	 * 
	 * @param headNode
	 * @param nodeToInsert
	 * @param position
	 * @return
	 */
	DLLNode insertDLL(DLLNode headNode, DLLNode nodeToInsert, int position) {
		if (headNode == null) {
			return nodeToInsert;
		}

		int size = getDLLLength(headNode);

		if (position > size + 1 || position < 1) {
			System.out.println("posistion of node to insert is invalid." + "The valid inputs are 1 tp " + (size + 1));
			return headNode;
		}

		if (position == 1) {// 在链表开头插入
			nodeToInsert.setNext(headNode);
			headNode.setPrevious(nodeToInsert);
			return nodeToInsert;
		} else {// 在链表中间或末尾插入
			DLLNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}

			DLLNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);

			if (currentNode != null) {
				currentNode.setPrevious(nodeToInsert);
			}
			previousNode.setNext(nodeToInsert);
			nodeToInsert.setPrevious(previousNode);
		}
		return headNode;
	}

	/**
	 * 删除双向链表中间的一个结点
	 * @param headNode
	 * @param position
	 * @return
	 */
	DLLNode deleteDLL(DLLNode headNode, int position) {
		int size = getDLLLength(headNode);
		if (position > size + 1 || position < 1) {
			System.out.println("posistion of node to insert is invalid." + "The valid inputs are 1 tp " + size);
			return headNode;
		}

		if (position == 1) {// 删除链表的第一个结点
			DLLNode currentNode = headNode.getNext();
			headNode = null;
			currentNode.setPrevious(null);
			return currentNode;
		} else {// 删除链表中间或末尾结点
			DLLNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}

			DLLNode currentNode = previousNode.getNext();
			DLLNode laterNode = currentNode.getNext();
			previousNode.setNext(laterNode);
			if (laterNode != null) {
				laterNode.setPrevious(previousNode);
			}
			currentNode = null;
		}
		return headNode;

	}
}
