class Car {
    int position;
    int speed;
    
    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        
        for(int i = 0 ; i < position.length ; i++)
            cars[i] = new Car(position[i], speed[i]);
        
        Arrays.sort(cars, (x, y) -> Integer.compare(x.position, y.position));
        
        Set<Double> arrivalTimes = new HashSet<>();
        double nextCarArrivalTime = Integer.MAX_VALUE;
        for(int i = cars.length - 1 ; i >= 0 ; i--) {
            Car currentCar = cars[i];
            double normalArrivalTime = (double)currentCar.speed/(target-currentCar.position);
            double carArrivalTime = Math.min(normalArrivalTime, nextCarArrivalTime);
            arrivalTimes.add(carArrivalTime);
            nextCarArrivalTime = carArrivalTime;
        }
        
        
        return arrivalTimes.size();
        
    }
}