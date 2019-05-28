package groupproject.itmd515finalproject;

/*
Deborah Barndt
	 Thomas Boller
	 2-23-18
	 parseAndUpdage.java
	 Project Assignment 1
	This is a class used to act as main for testing our project assignment 1 files
*/


public class parseAndUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XmlParser parse = new XmlParser();
		DAO daoO = new DAO();
		
		parse.parseDTXML();
		daoO.createTables();
		daoO.insertDtRecords(parse.getDtArray());
		
		parse.parseTTXML();
		daoO.insertTaxRecords(parse.gettTaxArray());
		
		parse.parseUserXML();
		daoO.insertUsers(parse.getUsrArray());
		
		parse.parsePaymentXML();
		daoO.insertPayment(parse.getPayArray());
		
		parse.parseVehiclesXML();
		daoO.insertVehicles(parse.getVArray());
		
		parse.parseDriversXML();
		daoO.insertDrivers(parse.getDriverArray());
		
		
	}

}
