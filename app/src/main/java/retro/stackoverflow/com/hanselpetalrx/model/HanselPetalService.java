package retro.stackoverflow.com.hanselpetalrx.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * This will be the object we will intercat with to make netwoek calls from the UI level
 * When constructing an implementation of HanselPetalApi through Retrofit, we need pass in
 * an RxJavaCallAdapterFactory as the call adapter - so that network calls can return an
 * Observable object (note: passing a call adapter is needed for any network call that returns
 * anything other than a Call)
 */

public class HanselPetalService {

    private HanselPetalApi hanselPetalApi;
    private  static HanselPetalService sInstance;

    private HanselPetalService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HanselPetalApi.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        hanselPetalApi = retrofit.create(HanselPetalApi.class);
    }

    public Observable<List<Flower>> getFlowersResponse(){
        return hanselPetalApi.getFlowers();
    }

    public static HanselPetalService getServiceInstance(){
        return sInstance = new HanselPetalService();
    }
}
