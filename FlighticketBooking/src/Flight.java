import java.util.*;

public class Flight {

	// id for flight which is alloted everytime a new Flight Object is created
	static int id = 0;
	int flightID;
	// available ticket in current flight
	int tickets;
	// current price
	int price;
	// All Passengers Details
	ArrayList<String> passengerDetails;
	// Passengers ID
	ArrayList<Integer> passengerIDs;
	// How Many Ticket they booked
	ArrayList<Integer> bookedTicPerPassenger;
	// Cost of PassangerId and Refund Amount
	ArrayList<Integer> passengerCost;

	// ConstructorSEtDetails
	public Flight() {
		tickets = 50;
		price = 5000;
		id = id + 1;
		flightID = id;
		passengerDetails = new ArrayList<String>();
		passengerIDs = new ArrayList<Integer>();
		bookedTicPerPassenger = new ArrayList<Integer>();
		passengerCost = new ArrayList<Integer>();
	}

	// add passenger details to flight
	public void addPassangersDetails(String passangerDetail, int numOfTickets, int passangerID) {
		passengerDetails.add(passangerDetail);
		passengerIDs.add(passangerID);
		passengerCost.add(price * numOfTickets);
		// priceList Update
		price += 200 * numOfTickets;

		// UpdatatingAvailableTciketDetails
		tickets -= numOfTickets;
		bookedTicPerPassenger.add(numOfTickets);

		System.out.println("Successfully Booked your Tickets");

	}

	public void cancelTickets(int passengerID) {
		// find the index to remove from all lists
		int indexToRemove = passengerIDs.indexOf(passengerID);
		if (indexToRemove < 0) {
			System.out.println("Passenger id Not Found ..!");
			return;
		}

		int ticketsToCancel = bookedTicPerPassenger.get(indexToRemove);

		// increaseAvailableTickets
		tickets += ticketsToCancel;
		// Change Price to New ..after CAncelation
		price -= 200 * ticketsToCancel;

		System.out.println("Refund Amount AFter Cancel your Tickets : " + passengerCost.get(indexToRemove));

		// remove details frompassenger lists
		bookedTicPerPassenger.remove(indexToRemove);
		passengerIDs.remove(Integer.valueOf(passengerID));
		passengerDetails.remove(indexToRemove);
		passengerCost.remove(indexToRemove);

		System.out.println("Your Tickets Cancelled Successfully");
	}

	public void flightDetails() {
		System.out.println("Flight Name = " + flightID + "-->" + "Remaining Tickets = " + tickets + "-->"
				+ "CurrentTicketPrice = " + price);
	}

	public void printDetails() {
		System.out.println("Flight ID " + flightID + "-->");
		for (String details : passengerDetails)
			System.out.println(details);
	}

}
