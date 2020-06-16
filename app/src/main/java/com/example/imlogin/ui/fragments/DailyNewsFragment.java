package com.example.imlogin.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imlogin.R;
import com.example.imlogin.adapter.DailyAdapter;
import com.example.imlogin.api.ApiService;
import com.example.imlogin.bean.DailyBean;
import com.example.imlogin.ui.activity.CalenderActivity;
import com.example.imlogin.ui.activity.DailyNewsDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyNewsFragment extends Fragment {
    private static final String TAG = "DailyNewsFragment";

    @BindView(R.id.recycler_daily)
    RecyclerView recyclerDaily;
    Unbinder unbinder;
    @BindView(R.id.fab_daily_news)
    FloatingActionButton fabDailyNews;
    private DailyAdapter dailyAdapter;
    private List<DailyBean.StoriesBean> list;
    private List<DailyBean.TopStoriesBean> banner;

    public DailyNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_daily_news, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseZhiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getDailyData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyBean dailyBean) {
                        List<DailyBean.StoriesBean> lists = dailyBean.getStories();
                        List<DailyBean.TopStoriesBean> topStories = dailyBean.getTop_stories();
                        if (lists != null && lists.size() >= 0) {
                            list.addAll(lists);
                        }
                        if (topStories != null && topStories.size() >= 0) {
                            banner.addAll(topStories);
                        }
                        dailyAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        recyclerDaily.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerDaily.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));
        list = new ArrayList<>();
        banner = new ArrayList<>();
        dailyAdapter = new DailyAdapter(getActivity(), list, banner);
        recyclerDaily.setAdapter(dailyAdapter);

        dailyAdapter.setOnCilckListenerDaily(new DailyAdapter.OnCilckListenerDaily() {
            @Override
            public void onClick(int post) {
                DailyBean.StoriesBean storiesBean = list.get(post);
                Intent intent = new Intent(getActivity(), DailyNewsDetailsActivity.class);
                intent.putExtra("title",storiesBean.getTitle());
                intent.putExtra("img",storiesBean.getImages().get(0));
                intent.putExtra("id",storiesBean.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab_daily_news)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), CalenderActivity.class));
    }
}
