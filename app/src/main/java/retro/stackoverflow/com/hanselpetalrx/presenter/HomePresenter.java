package retro.stackoverflow.com.hanselpetalrx.presenter;

import android.util.Log;

import java.util.List;

import retro.stackoverflow.com.hanselpetalrx.model.Flower;
import retro.stackoverflow.com.hanselpetalrx.model.HanselPetalService;
import retro.stackoverflow.com.hanselpetalrx.view.HomeInteractor;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmcg2 on 05/02/2017.
 */

public class HomePresenter {
    public static final String TAG = HomePresenter.class.getSimpleName();

    private HomeInteractor view;
    private Subscription subscription;

    public HomePresenter(HomeInteractor view) {
        this.view = view;
    }

    public void fetchData(){
        subscription = HanselPetalService
                .getServiceInstance()
                .getFlowersResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Flower>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<Flower> flowers) {
                        Log.d(TAG, "onNext: data received!" + flowers.toString());
                        view.hideProgress();
                        view.updateView(flowers);
                    }
                });
    }


}
