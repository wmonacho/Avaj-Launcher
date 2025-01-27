public class Main {
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        
        Helicopter helicopter = new Helicopter("Heli1", 10, 100);
        Airplane airplane = new Airplane("Plane1", 20, 200);
        Balloon balloon = new Balloon("Balloon1", 5, 50);
        
        weatherTower.registerFlyable(helicopter);
        weatherTower.registerFlyable(airplane);
        weatherTower.registerFlyable(balloon);
        
        helicopter.fly();
        airplane.fly();
        balloon.fly();
        
        weatherTower.checkWeather();
    }
}