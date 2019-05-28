import java.util.Comparator;

public class FemaleComparator implements Comparator<BankRecords>{

	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		// TODO Auto-generated method stub
		//first sort
		int result = o1.getSex().compareTo(o2.getSex());
		if (result !=0)  { return result; }
		//second sort
		return o1.getMortgage().compareTo(o2.getMortgage());
	}

}
