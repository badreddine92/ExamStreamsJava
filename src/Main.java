import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {

    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 p1 = new Partie1();
    System.out.println(p1.longAndExpensiveTrips(trips));
    System.out.println(p1.badTrips(trips));
    System.out.println(p1.recentTrips(trips));

    Partie2 p2 = new Partie2();
    System.out.println(p2.countByCity(trips));
    System.out.println(p2.revenueByDriver(trips));
    System.out.println(p2.avgDurationByCity(trips));

    Partie3 p3 = new Partie3();
    System.out.println(p3.top10ExpensiveTrips(trips));
    System.out.println(p3.bestTrip(trips));

    Partie4 p4 = new Partie4();
    System.out.println(p4.totalRevenueSequential(trips));
    System.out.println(p4.totalRevenueParallel(trips));
    System.out.println(p4.countByCityParallel(trips));
    System.out.println(p4.premiumTripsParallel(trips));

    System.out.println("\n=== PERF TEST (10M trips) ===");
    List<Trip> bigList = TripFactory.generateTrips(10_000_000);

    long t1 = System.currentTimeMillis();
    double revSeq = p4.totalRevenueSequential(bigList);
    System.out.println("Sequential: " + revSeq + " en " + (System.currentTimeMillis() - t1) + "ms");

    long t2 = System.currentTimeMillis();
    double revPar = p4.totalRevenueParallel(bigList);
    System.out.println("Parallel:   " + revPar + " en " + (System.currentTimeMillis() - t2) + "ms");
}