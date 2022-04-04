import java.util.Scanner;
public class AttractionForce{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Introduza a latitude da primeira pessoa.");
        float lat1 = input.nextFloat();
        System.out.print("Introduza a longitude da primeira pessoa.");
        float long1 = input.nextFloat();
        // System.out.print("Introduza a massa da primeira pessoa.");
        // float m1 = input.nextFloat();
        System.out.print("Introduza a latitude da segunda pessoa.");
        float lat2 = input.nextFloat();
        System.out.print("Introduza a longitude da segunda pessoa.");
        float long2 = input.nextFloat();
        // System.out.print("Introduza a massa da segunda pessoa.");
        // float m2 = input.nextFloat();

        input.close();

        System.out.print(distance(coordinatesTransform(lat1, long1), coordinatesTransform(lat2, long2)));

    }

    public static double[] coordinatesTransform(float latitude, float longitude, int radius){

        double[] coordinates = new double[3];
        double lat = Math.toRadians(latitude);
        double log = Math.toRadians(longitude);
        coordinates[1] = radius*Math.cos(lat)*Math.cos(log);
        coordinates[0] = radius*Math.cos(lat)*Math.sin(log);
        coordinates[2] = -radius*Math.sin(lat);

        return coordinates;


    }
    public static double[] coordinatesTransform(float latitude, float longitude){

        return coordinatesTransform(latitude, longitude, 6366707);
    }

    public static double distance(double Xa,double Ya, double Za,double Xb,double Yb, double Zb){

        return Math.sqrt(Math.pow(Xa-Xb,2)+Math.pow(Ya-Yb,2)+Math.pow(Za-Zb,2));

    }
    public static double distance(double[] A,double[] B){

        return distance(A[0], A[1], A[2], B[0], B[1], B[2]);

    }

    public static double force(float ma, float mb, double d){

        final double G = 6.67*Math.pow(10,-11);

        return G*ma*mb*Math.pow(d,-2);

    }

}