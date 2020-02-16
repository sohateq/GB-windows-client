import ObjectsFromServer.Order;
import ObjectsFromServer.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import java.util.List;

public abstract class ClientController {
    public static void getProductsStringFromServer(){
        ClientConfig clientConfig = new DefaultClientConfig();

        // Create Client based on Config
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://35.237.102.95:8080/api/v1/products");

        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
            return;
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);

    }

    public static void getProductsListFromServer () {
        ClientConfig clientConfig = new DefaultClientConfig();

        // Create Client based on Config
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://35.237.102.95:8080/api/v1/products");

        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
            return;
        }

        GenericType<List<Product>> generic = new GenericType<List<Product>>() {
            // No thing
        };

        List<Product> list = response.getEntity(generic);

        System.out.println("Output from Server .... \n");

        for (Product product : list) {
            System.out.println(" --- ");
            System.out.println(product.toString());
        }
    }

    public static void getOrdersStringFromServer(){
        ClientConfig clientConfig = new DefaultClientConfig();

        // Create Client based on Config
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://35.237.102.95:8080/api/v1/orders");

        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
            return;
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);

    }

    public static void getOrdersListFromServer () {
        ClientConfig clientConfig = new DefaultClientConfig();

        // Create Client based on Config
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://35.237.102.95:8080/api/v1/oeders");

        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
            return;
        }

        GenericType<List<Order>> generic = new GenericType<List<Order>>() {
            // No thing
        };

        List<Order> list = response.getEntity(generic);

        System.out.println("Output from Server .... \n");

        for (Order order : list) {
            System.out.println(" --- ");
            System.out.println(order.toString());
        }
    }

}
