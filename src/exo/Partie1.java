package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    // Lambdas déclarées en variables
    Predicate<Trip> isLongTrip = trip -> trip.distanceKm() > 10;
    Predicate<Trip> isExpensiveTrip = trip -> trip.price() > 20;
    Predicate<Trip> isBadTrip = trip -> trip.rating() < 3;
    Predicate<Trip> isRecentTrip = trip -> {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tripDate = trip.startTime().toLocalDate();
        return tripDate.equals(today) || tripDate.equals(yesterday);
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isLongTrip.and(isExpensiveTrip))
                .toList();
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isBadTrip)
                .toList();
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isRecentTrip)
                .toList();
    }
}