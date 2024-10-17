package com.alura.conversorMonedas.principal;

import com.alura.conversorMonedas.modelos.Conversor;
import com.alura.conversorMonedas.modelos.moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class busquedaApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leer = new Scanner(System.in);
        String continuar;

        do {
            // Mostrar el menú de monedas
            System.out.println("Seleccione la moneda local:");
            System.out.println("1. ARS - Peso argentino");
            System.out.println("2. BOB - Boliviano boliviano");
            System.out.println("3. BRL - Real brasileño");
            System.out.println("4. CLP - Peso chileno");
            System.out.println("5. COP - Peso colombiano");
            System.out.println("6. USD - Dólar estadounidense");
            System.out.println("0. Salir");
            int opcionLocal = leer.nextInt();

            // Salir del bucle si elige 0
            if (opcionLocal == 0) {
                System.out.println("Saliendo del programa.");
                break;
            }

            String monedaLocal = obtenerMoneda(opcionLocal);

            // Mostrar el menú para seleccionar la moneda a convertir
            System.out.println("Seleccione la moneda a convertir:");
            // Repite el menú de monedas
            for (int i = 1; i <= 6; i++) {
                System.out.println(i + ". " + obtenerMoneda(i));
            }
            int opcionConvertir = leer.nextInt();
            String monedaConvertir = obtenerMoneda(opcionConvertir);

            System.out.println("Ingrese la cantidad a convertir:");
            int valorMoneda = leer.nextInt();

            String dir = "https://v6.exchangerate-api.com/v6/54637fb7bd9ed652a9d9ed07/pair/" + monedaLocal + "/" + monedaConvertir;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(dir))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            /*System.out.println(json);*/

            Gson gson = new Gson();
            moneda miMoneda = gson.fromJson(json, moneda.class);
            System.out.println(miMoneda);
            System.out.println("Valor convertido: " + (valorMoneda * miMoneda.getValor()));

            System.out.println("¿Desea realizar otra conversión? (s/n)");
            continuar = leer.next();
        } while (continuar.equalsIgnoreCase("s"));

        leer.close(); // Cierra el scanner
    }

    // Método para obtener la moneda según la opción
    private static String obtenerMoneda(int opcion) {
        switch (opcion) {
            case 1: return "ARS"; // Peso argentino
            case 2: return "BOB"; // Boliviano
            case 3: return "BRL"; // Real brasileño
            case 4: return "CLP"; // Peso chileno
            case 5: return "COP"; // Peso colombiano
            case 6: return "USD"; // Dólar estadounidense
            default: return "Moneda no válida"; // En caso de opción inválida
        }
    }
}