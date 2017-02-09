package retro.stackoverflow.com.hanselpetalrx.view;

import java.util.List;

import retro.stackoverflow.com.hanselpetalrx.model.Flower;

/**
 * Created by rmcg2 on 05/02/2017.
 */

public interface HomeInteractor {

    void showProgress();
    void hideProgress();
    void updateView(List<Flower> data);
}
