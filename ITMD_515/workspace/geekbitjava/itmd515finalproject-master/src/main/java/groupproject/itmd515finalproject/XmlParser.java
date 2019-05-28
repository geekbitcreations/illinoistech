package groupproject.itmd515finalproject;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlParser {
	
	
	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public XmlParser () {
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
	//lists and arrays that will hold all of the entity information to be passed via jdbc to sql
		//PURPOSE: lists allow for dynamic memory allocation, arrays are more easily passed to be stored.
		
	//Delivery Transactions
	private DeliveryTransactions [] dtArray;
	private ArrayList<DeliveryTransactions> dtList = new ArrayList<DeliveryTransactions>();
	
	//Taxi Transactions
	private TaxiTransactions [] taxArray;
	private ArrayList<TaxiTransactions> taxList = new ArrayList<TaxiTransactions>();
	
	//Users
	private Users [] UsrArray;
	private ArrayList<Users> UsrList = new ArrayList<Users>();
	
	//Payment
	private Payment [] PayArray;
	private ArrayList<Payment> PayList = new ArrayList<Payment>();
	
	//Vehicles
	private Vehicles [] VArray;
	private ArrayList<Vehicles> VList = new ArrayList<Vehicles>();
	
	//Drivers
	private Drivers [] DriverArray;
	private ArrayList<Drivers> DriverList = new ArrayList<Drivers>();
	
	//method to parse through the delivery transactions xml
	public void parseDTXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("deliverytrans.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transaction");

			System.out.println("----------------------------");
			System.out.println("Reading Delivery Transactions from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);
				//creates new DeliveryTransactions obj in dtList
				//dtList[index] = new DeliveryTransactions(); 

				dtList.add(new DeliveryTransactions());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					dtList.get(index).setTid(Integer.parseInt(eElement.getElementsByTagName("trans_id").item(0).getTextContent()));
					dtList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());
					dtList.get(index).setDriverid(eElement.getElementsByTagName("driver_id").item(0).getTextContent());
					dtList.get(index).setDateOfSale(java.sql.Date.valueOf(eElement.getElementsByTagName("date").item(0).getTextContent()));
					dtList.get(index).setRate(Double.parseDouble(eElement.getElementsByTagName("rate").item(0).getTextContent()));
					dtList.get(index).setPickupTime(java.sql.Time.valueOf(eElement.getElementsByTagName("pickup_time").item(0).getTextContent()));
					dtList.get(index).setPickupLocation(eElement.getElementsByTagName("pickup_loc").item(0).getTextContent());
					dtList.get(index).setDropoffTime(java.sql.Time.valueOf(eElement.getElementsByTagName("drop_time").item(0).getTextContent()));
					dtList.get(index).setDropoffLocation(eElement.getElementsByTagName("drop_loc").item(0).getTextContent());
					//note package size will take only the first char as an upper case so if xml has large it will be stored as L
					dtList.get(index).setPackageSize(eElement.getElementsByTagName("drop_loc").item(0).getTextContent().toUpperCase().charAt(0));

				}
			}
			dtArray = dtList.toArray(new DeliveryTransactions[dtList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }
		  }

	
	
	public DeliveryTransactions[] getDtArray() {
		return dtArray;
	}

	public void setDtArray(DeliveryTransactions[] dtArray) {
		this.dtArray = dtArray;
	}

	public void parseTTXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("taxitrans.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transaction");

			System.out.println("----------------------------");
			System.out.println("Reading Taxi Transactions from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				taxList.add(new TaxiTransactions());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					taxList.get(index).setTid(Integer.parseInt(eElement.getElementsByTagName("trans_id").item(0).getTextContent()));
					taxList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());
					taxList.get(index).setDriverid(eElement.getElementsByTagName("driver_id").item(0).getTextContent());
					taxList.get(index).setDateOfSale(java.sql.Date.valueOf(eElement.getElementsByTagName("date").item(0).getTextContent()));
					taxList.get(index).setRate(Double.parseDouble(eElement.getElementsByTagName("rate").item(0).getTextContent()));
					taxList.get(index).setPickupTime(java.sql.Time.valueOf(eElement.getElementsByTagName("pickup_time").item(0).getTextContent()));
					taxList.get(index).setPickupLocation(eElement.getElementsByTagName("pickup_loc").item(0).getTextContent());
					taxList.get(index).setDropoffTime(java.sql.Time.valueOf(eElement.getElementsByTagName("drop_time").item(0).getTextContent()));
					taxList.get(index).setDropoffLocation(eElement.getElementsByTagName("drop_loc").item(0).getTextContent());
					taxList.get(index).setRating(Byte.valueOf(eElement.getElementsByTagName("rating").item(0).getTextContent()));

				}
			}
			taxArray = taxList.toArray(new TaxiTransactions[taxList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}

	public TaxiTransactions[] gettTaxArray() {
		return taxArray;
	}

	public void setTaxArray(TaxiTransactions[] taxArray) {
		this.taxArray = taxArray;
	}
	
	public void parseUserXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("users.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("user");

			System.out.println("----------------------------");
			System.out.println("Reading Users from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				UsrList.add(new Users());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					UsrList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());;
					UsrList.get(index).setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());;
					UsrList.get(index).setFirstName(eElement.getElementsByTagName("first_name").item(0).getTextContent());;
					UsrList.get(index).setLastName(eElement.getElementsByTagName("last_name").item(0).getTextContent());;
					UsrList.get(index).setUserType(eElement.getElementsByTagName("user_type").item(0).getTextContent());;
					UsrList.get(index).setRating(Byte.valueOf(eElement.getElementsByTagName("rating").item(0).getTextContent()));;
					UsrList.get(index).setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());;
					UsrList.get(index).setCurr_Loc(eElement.getElementsByTagName("current_loc").item(0).getTextContent());;

				}
			}
			UsrArray = UsrList.toArray(new Users[UsrList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}	
	
	public Users[] getUsrArray() {
		return UsrArray;
	}

	public void setUsrArray(Users[] UsrArray) {
		this.UsrArray = UsrArray;
	}

	public void parsePaymentXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("payment.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("paymentinfo");

			System.out.println("----------------------------");
			System.out.println("Reading Payments from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				PayList.add(new Payment());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					PayList.get(index).setNameOnCard(eElement.getElementsByTagName("name_on_card").item(0).getTextContent());;
					PayList.get(index).setCardNumber(Long.parseLong(eElement.getElementsByTagName("card_number").item(0).getTextContent()));;
					PayList.get(index).setExpDate(java.sql.Date.valueOf(eElement.getElementsByTagName("exp_date").item(0).getTextContent()));;
					PayList.get(index).setCCV(Short.parseShort(eElement.getElementsByTagName("ccv").item(0).getTextContent()));;
					PayList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());;
					PayList.get(index).setPid(Integer.parseInt(eElement.getElementsByTagName("pid").item(0).getTextContent()));

				}
			}
			PayArray = PayList.toArray(new Payment[PayList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}	
	
	public Payment[] getPayArray() {
		return PayArray;
	}

	public void setPayArray(Payment[] PayArray) {
		this.PayArray = PayArray;
	}	
	
	public void parseVehiclesXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("vehicles.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("vehicle");

			System.out.println("----------------------------");
			System.out.println("Reading Vehicles from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				VList.add(new Vehicles());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					VList.get(index).setVehicleId(Integer.parseInt(eElement.getElementsByTagName("vehicle_id").item(0).getTextContent()));;
					VList.get(index).setMake(eElement.getElementsByTagName("make").item(0).getTextContent());;
					VList.get(index).setModel(eElement.getElementsByTagName("model").item(0).getTextContent());;
					VList.get(index).setYear(Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()));;
					VList.get(index).setLicensePlate(eElement.getElementsByTagName("license_plate").item(0).getTextContent());;
					VList.get(index).setColor(eElement.getElementsByTagName("color").item(0).getTextContent());;

				}
			}
			VArray = VList.toArray(new Vehicles[VList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}	
	
	public Vehicles[] getVArray() {
		return VArray;
	}

	public void setVArray(Vehicles[] VArray) {
		this.VArray = VArray;
	}	
	
	public void parseDriversXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("drivers.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("driver");

			System.out.println("----------------------------");
			System.out.println("Reading Drivers from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				DriverList.add(new Drivers());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					DriverList.get(index).setVehicleId(Integer.parseInt(eElement.getElementsByTagName("vehicle_id").item(0).getTextContent()));;
					DriverList.get(index).setDriverType(eElement.getElementsByTagName("driver_type").item(0).getTextContent());;
					DriverList.get(index).setLicense(eElement.getElementsByTagName("license").item(0).getTextContent());;
					DriverList.get(index).setUserId(eElement.getElementsByTagName("user_id").item(0).getTextContent());;
					DriverList.get(index).setName(eElement.getElementsByTagName("name").item(0).getTextContent());;
					DriverList.get(index).setCurrentLoc(eElement.getElementsByTagName("current_loc").item(0).getTextContent());;

				}
			}
			DriverArray = DriverList.toArray(new Drivers[DriverList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}	
	
	public Drivers[] getDriverArray() {
		return DriverArray;
	}

	public void setDriverArray(Drivers[] DriverArray) {
		this.DriverArray = DriverArray;
	}		
}
