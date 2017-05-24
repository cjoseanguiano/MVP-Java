package com.devix.www.mvpjava.Login.Interface.Main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.devix.www.mvpjava.Login.Interface.Main.Interface.MainPresenter;
import com.devix.www.mvpjava.Login.Interface.Main.Interface.MainView;
import com.devix.www.mvpjava.R;

import java.util.List;

public class MainActivity extends Activity implements MainView, AdapterView.OnItemClickListener {

    private ListView mlistView;
    private ProgressBar mprogressBar;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistView = (ListView) findViewById(R.id.Slist);
        mlistView.setOnItemClickListener(this);
        mprogressBar = (ProgressBar) findViewById(R.id.Sprogress);
        mPresenter = new MainPresenterImpl(this, new FindItemsInteractorImpl());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPresenter.onItemClicked(position);
    }

    @Override
    public void showProgress() {
        mprogressBar.setVisibility(View.VISIBLE);
        mlistView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void hideProgress() {
        mprogressBar.setVisibility(View.INVISIBLE);
        mlistView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        mlistView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
