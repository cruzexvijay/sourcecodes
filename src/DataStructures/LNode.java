package DataStructures;

/**
 * template class for node
 * @author 590834
 *
 */
public class LNode{
	public int data;
	public LNode next;
	
	LNode(int data){
		this.data = data;
		this.next=null;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("removed : "+this.data);
		super.finalize();
	}
	
	
}
