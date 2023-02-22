import java.util.*;
public class BookTicket {
	public static void book(Flight currentFlight, int tickets,int passengerID)
	{
		String passengerDetail = "";
		//Create PassengerID
		passengerDetail = "Passenger ID" + passengerID + " - - " + " Number of Tickets Booked " + tickets + " -- " + " Total Cost " + currentFlight.price * tickets;
		// add passenger detail to flight object
		currentFlight.addPassangersDetails(passengerDetail, tickets, passengerID);
		currentFlight.flightDetails();
		currentFlight.printDetails();
	}
	public static void cancel(Flight currentFlight, int passengerID)
	{
		currentFlight.cancelTickets(passengerID);
		currentFlight.flightDetails();
		currentFlight.printDetails();
	}
	public static void print(Flight f)
	{
		f.printDetails();
	}
	public static void main(String[] args) {
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		// Create new Flight ...1 and 2
		for(int i = 0; i<2; i++)
			flights.add(new Flight());
		
		// unique id for passengers
		int passengerID = 1;
		
		while(true) {
			System.out.println("1. BookTicket "+"\n"+"2. Cancel Ticket "+"\n"+"3. Print Update Status ");
			Scanner s = new Scanner(System.in);
			int option = s.nextInt();
			
			switch(option)
			{
			//book
			case 1:
			{
				System.out.println("Enter flight id");
				int fid = s.nextInt();
				
				if(fid>flights.size())
				{
					System.out.println("Invalid Flight IDs, Choose Correct Id");
					break;
				}
					Flight currentFlight = null;
					for(Flight f : flights)
					{
						if(f.flightID == fid)
						{
							currentFlight = f;
							f.flightDetails();
							break;
						}
					}
					System.out.println("ENter No Of Tickets you Want?");
					int t = s.nextInt();
					
					if(t>currentFlight.tickets)
					{
						System.out.println("Not Enough Tickets");
						break;
					}
					book(currentFlight,t,passengerID);
					passengerID = passengerID + 1;
					break;
			}
			//cancel
			case 2:
			{
				

				System.out.println("Enter Flight ID and Passenger ID to Cancel your Tickets");
				int fid = s.nextInt();
				
				if(fid>flights.size())
				{
					System.out.println("Invalid Flight ID");
					break;
				}
				Flight currentFlight = null;
				for(Flight f : flights)
				{
					currentFlight = f;
					break;
				}
				int id = s.nextInt();
				cancel(currentFlight,id);
				break;
			}
			case 3:
			{
				for(Flight f : flights)
				{
					if(f.passengerDetails.size()==0)
					{
						System.out.println("No passenger Details for  - Flight " + f.flightID);
					}
					else
						print(f);
						
				}
				break;
			}
			default:
			{
				break;
			}
				
			}
		}

	}

}
