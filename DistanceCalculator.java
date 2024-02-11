import java.util.Scanner;

public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты первой точки (широта и долгота через пробел):");
        double lat1 = scanner.nextDouble();
        double lon1 = scanner.nextDouble();
        System.out.println("Введите координаты второй точки (широта и долгота через пробел):");
        double lat2 = scanner.nextDouble();
        double lon2 = scanner.nextDouble();
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");
        scanner.close();
    }
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}
