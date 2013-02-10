package nobs.products;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/product")
public class ProductResource {

    @GET
    @Path("/{id}")
    public String getProduct(@PathParam("id") int id) {
        return "Product: " + id;
    }
}
