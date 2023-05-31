An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.
  Solution:

class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, TravelInfo> travelTimes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkIns.remove(id);
        String travel = checkInInfo.stationName + "," + stationName;
        int travelTime = t - checkInInfo.checkInTime;

        if (travelTimes.containsKey(travel)) {
            TravelInfo travelInfo = travelTimes.get(travel);
            travelInfo.totalTime += travelTime;
            travelInfo.count++;
        } else {
            travelTimes.put(travel, new TravelInfo(travelTime, 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String travel = startStation + "," + endStation;
        TravelInfo travelInfo = travelTimes.get(travel);
        return (double) travelInfo.totalTime / travelInfo.count;
    }

    private class CheckInInfo {
        String stationName;
        int checkInTime;

        public CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private class TravelInfo {
        int totalTime;
        int count;

        public TravelInfo(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}
