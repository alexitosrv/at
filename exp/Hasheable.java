import java.util.List;
import java.util.HashSet;

public class Hasheable{
	public List<String> names;
	
	
	Hasheable (List<String> ns) { this.names = ns; }
	
	
	@Override
	public boolean equals(Object o){
		if (o == null || !(o instanceof Hasheable)){
			return false;
		}
		
		return this == o ? true : new HashSet<String>(names).equals( new HashSet<String>( ((Hasheable)o).names ) );
	}

	
	@Override
	public int hashCode(){
		return new HashSet<String>(names).hashCode();
	}
	
	
}