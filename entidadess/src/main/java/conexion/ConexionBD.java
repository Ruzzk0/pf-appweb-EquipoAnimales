/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author diana
 */
public class ConexionBD {
    private static ConexionBD instance;
    private final String direccion = "mongodb://localhost:27017/";
    private final String nombreBD = "PotroP";
    private final MongoDatabase mongoDatabase;

    private ConexionBD() {
        // Configuración del codec para manejar POJOs
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        // Configuración de los ajustes del cliente MongoDB
MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(new com.mongodb.ConnectionString(direccion))
                .codecRegistry(pojoCodecRegistry)
                .writeConcern(com.mongodb.WriteConcern.ACKNOWLEDGED) // Cambia a WriteConcern.DEFAULT
                .build();


        // Creación de la instancia de MongoDatabase
        mongoDatabase = MongoClients.create(clientSettings).getDatabase(nombreBD);
    }

    public static ConexionBD getInstance() {
        if (instance == null) {
            synchronized (ConexionBD.class) {
                if (instance == null) {
                    instance = new ConexionBD();
                }
            }
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return mongoDatabase;
    }
}

