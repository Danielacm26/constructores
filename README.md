# Generador de Tabla de Constructores de F1

Este proyecto en Java permite conectarse a una base de datos PostgreSQL, consultar la información de los constructores de Fórmula 1 y mostrar una tabla con los constructores con más puntos ganados en el Campeonato Mundial de Fórmula 1 desde 1950 hasta 2024. 

Este código Java realiza los siguientes pasos:

- Conecta a la base de datos PostgreSQL usando JDBC.
- Ejecuta una consulta SQL para obtener los constructores con más puntos.
- Construye una tabla ASCII con los resultados utilizando la biblioteca asciitable.
- Muestra la tabla en la consola.
- Cierra los recursos de la base de datos para evitar fugas de memoria.

El objetivo es presentar los datos de forma clara y estructurada, utilizando una tabla que facilita la lectura de los constructores más exitosos en términos de puntos ganados en la historia de la Fórmula 1.

## codigo
package constructoress;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_FixedWidth;
import de.vandermeer.asciithemes.a7.A7_Grids;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Constructores {
    public static void main(String[] args) {
        // Datos de conexión a la base de datos
        String url = "jdbc:postgresql://localhost:5432/tu_base_de_datos";
        String user = "tu_usuario";
        String password = "tu_contraseña";

        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(url, user, password);

            // Crear una declaración
            Statement stmt = conn.createStatement();

            // Ejecutar la consulta para obtener los constructores con más puntos
            String query = "SELECT constructor_nombre, SUM(puntos) as total_puntos FROM puntos_constructores GROUP BY constructor_nombre ORDER BY total_puntos DESC";
            ResultSet rs = stmt.executeQuery(query);

            // Crear una tabla ASCII
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow("Constructor", "Puntos");
            at.addRule();
            while (rs.next()) {
                String nombre = rs.getString("constructor_nombre");
                double puntos = rs.getDouble("total_puntos");
                at.addRow(nombre, puntos);
                at.addRule();
            }

            // Ajustar la tabla para mejor presentación
            at.getRenderer().setCWC(new CWC_FixedWidth().add(30).add(10));
            at.getContext().setGrid(A7_Grids.minusBarPlusEquals());

            // Imprimir la tabla
            String rend = at.render();
            System.out.println(rend);

            // Cerrar la conexión
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

## ejecucion 

[![Whats-App-Image-2024-07-22-at-1-26-19-PM.jpg](https://i.postimg.cc/DfGxBSBk/Whats-App-Image-2024-07-22-at-1-26-19-PM.jpg)](https://postimg.cc/yWVhNYMv)

