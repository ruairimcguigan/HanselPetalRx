package retro.stackoverflow.com.hanselpetalrx.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import retro.stackoverflow.com.hanselpetalrx.R;
import retro.stackoverflow.com.hanselpetalrx.model.Flower;
import retro.stackoverflow.com.hanselpetalrx.presenter.FlowerListAdapter;
import retro.stackoverflow.com.hanselpetalrx.presenter.HomePresenter;

/**
 * Created by rmcg2 on 05/02/2017.
 */

public class HomeView extends AppCompatActivity implements HomeInteractor, OnClickListener{

    HomePresenter presenter;
    Button clearButton, fetchButton;
    RecyclerView listView;
    FlowerListAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        attachPresenter();
        setAdapter();
        setOnClickListener();
    }


    private void initViews() {
        progressBar = (ProgressBar)findViewById(R.id.progress);
        clearButton = (Button)findViewById(R.id.clear_button);
        fetchButton= (Button)findViewById(R.id.fetch_button);
        listView = (RecyclerView)findViewById(R.id.listView);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setHasFixedSize(true);
    }

    private void setAdapter() {
        adapter = new FlowerListAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void updateView(List<Flower> data) {
        // set response on list adapter and set adapter on list
        adapter.populate(data);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void setOnClickListener() {
        clearButton.setOnClickListener(this);
        fetchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fetch_button:
                showProgress();
                presenter.fetchData();
                break;
            case R.id.clear_button:
                // clear adapter
        }
    }

    private void attachPresenter() {
        presenter = new HomePresenter(this);
    }

}
