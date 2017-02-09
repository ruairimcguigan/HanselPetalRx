package retro.stackoverflow.com.hanselpetalrx.model;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * We pass this interface into Retrofit and Retrofit will create an implementation of GitHubService
 */

public interface HanselPetalApi {

    public static final String BASE_URL = "http://www.services.hanselandpetal.com/";

    @GET("/feeds/flowers.json")
    Observable<List<Flower>> getFlowers();

}
