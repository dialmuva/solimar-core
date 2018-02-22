package hello;

import java.text.ParseException;
import com.solimar.repositories.ReservationRepositorySQL;
import com.solimar.views.ResponseView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solimar.domain.Reservation;
import com.solimar.repositories.ReservationRepository;

@RestController
public class ReservationController {
	
    @RequestMapping("/availability")
    public ResponseView reservation(@RequestParam(value="arriveDate", defaultValue="") String arriveDate
    										,@RequestParam(value="departureDate", defaultValue="") String departureDate) {    	
    	System.out.println("I made it!" + arriveDate);
    	//ReservationRepositoryFake repo = new ReservationRepositoryFake();
    	ReservationRepositorySQL repo = new ReservationRepositorySQL();
    	System.out.println("Let's go!");
    	ArrayList<Reservation> reservations = repo.getReservations();
    	System.out.println("Doing Fine!");
    	Date d1 = convertFromString(arriveDate);
    	Date d2 = convertFromString(departureDate);
    	System.out.println("Date1:" + d1.toString());
    	System.out.println("Date2:" + d2.toString());
    	Optional<Reservation> r = checkReservation(reservations, d1, d2);
    	ResponseView rv = new ResponseView();
    	if(r.isPresent()){
    		rv.setResponseMessage("You are out of luck, dates are unavailable, try a new one.");
    		rv.setResponseStatusBool(false);
    	}else{
    		rv.setResponseMessage("Dates are available, come in!");
    		rv.setResponseStatusBool(true);
    	}
    	return rv;
    }
    
    private Optional<Reservation> checkReservation(ArrayList<Reservation> reservations, Date arriveDate, Date departureDate){
    	for(Reservation r : reservations){
    		System.out.println("Date arrival:" + r.getArriveDate().toString());
    		System.out.println("Date leaving:" + r.getDepartureDate().toString());
    		if(((arriveDate.equals(r.getArriveDate()) || arriveDate.equals(r.getDepartureDate()))
    			|| arriveDate.before(r.getDepartureDate()) && arriveDate.after(r.getArriveDate()))
    			|| ((departureDate.equals(r.getArriveDate()) || departureDate.equals(r.getDepartureDate()))
    			||((departureDate.after(r.getArriveDate()) && departureDate.before(r.getDepartureDate()))))){
    			System.out.println("Date found!");
    			return Optional.of(r);
    		}
    	}
    	System.out.println("Dates are free, come in!");
    	return Optional.empty();
    }
    
    private Date convertFromString(String dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
