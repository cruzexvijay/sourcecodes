package DataStructures;

import java.util.Objects;

/**
 * template class for node
 * @author 590834
 *
 */
public class LNode implements Cloneable{
	public Integer data;
	public LNode next;
	
	public LNode(int data){
		this.data = data;
		this.next=null;
	}

	public LNode(LNode copy){
		this.data = copy.data;
		this.next = copy.next;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LNode other = (LNode) obj;
		if (!Objects.equals(data, other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
}
