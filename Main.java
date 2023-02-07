import java.util.Scanner;

interface Despegar {
    public void despegar();
}

interface Aterrizar {
    public void aterrizar();
}

abstract class NaveEspacial {
    String propulsion;
    boolean tripulacion;
    int velocidad_maxima;

    public NaveEspacial(String propulsion, boolean tripulacion, int velocidad_maxima) {
        this.propulsion = propulsion;
        this.tripulacion = tripulacion;
        this.velocidad_maxima = velocidad_maxima;
    }
}

class NaveLanzadera extends NaveEspacial implements Despegar, Aterrizar {
    public NaveLanzadera(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave Lanzadera ha despegado con éxito utilizando propulsión "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave Lanzadera ha aterrizado con éxito en una plataforma Lanzadera.");
    }
}

class NaveNoTripuladas extends NaveEspacial implements Despegar, Aterrizar {
    public NaveNoTripuladas(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave No Tripuladas ha despegado con éxito utilizando propulsión  "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave No Tripuladas ha aterrizado con éxito en una base militar.");
    }
}

class NaveExploradora extends NaveEspacial implements Despegar, Aterrizar {
    public NaveExploradora(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave exploradora ha despegado con éxito utilizando propulsión  "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave exploradora ha aterrizado con éxito en un planeta desconocido.");
    }
}

class NaveTripuladas extends NaveEspacial implements Despegar, Aterrizar {
    public NaveTripuladas(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave Tripuladas ha despegado con éxito utilizando propulsión "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave Tripuladas ha aterrizado con éxito en un planeta desconocido.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Ingrese el tipo de nave (Lanzadera, NoTripuladas, Exploradora, Tripuladas): ");
        String tipoNave = sc.nextLine();
       
        System.out.print("Ingrese la propulsión: ");
        String propulsion = sc.nextLine();
       
        System.out.print("¿Hay tripulación? (Sí/No): ");
        boolean tripulacion = sc.nextLine().equalsIgnoreCase("Sí");
       
        System.out.print("Ingrese la velocidad: ");
        int velocidad = sc.nextInt();
       
       
        NaveEspacial nave = null;
        switch (tipoNave.toLowerCase()) {
            case "lanzadera":
                nave = new NaveLanzadera(propulsion,tripulacion,velocidad);
                break;
            case "not ripuladas":
                nave = new NaveNoTripuladas(propulsion,tripulacion,velocidad);
                break;
            case "exploradora":
                nave = new NaveExploradora(propulsion,tripulacion,velocidad);
                break;
            case "tripuladas":
                nave = new NaveTripuladas(propulsion,tripulacion,velocidad);
                break;
            default:
                System.out.println("Tipo de nave no válido");
                break;
        }
        if(nave != null){
            ((Despegar) nave).despegar();
            ((Aterrizar) nave).aterrizar();
        }
    }
}
