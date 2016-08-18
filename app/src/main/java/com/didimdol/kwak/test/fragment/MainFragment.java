package com.didimdol.kwak.test.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.ContentActivity;
import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.adapter.MainListAdapter;
import com.didimdol.kwak.test.data.AirBnBCommend;
import com.didimdol.kwak.test.data.GuideData;
import com.didimdol.kwak.test.data.HostCommend;
import com.didimdol.kwak.test.data.ImageData;
import com.didimdol.kwak.test.data.MainData;
import com.didimdol.kwak.test.data.PopularData;
import com.didimdol.kwak.test.data.SearchImage;
import com.didimdol.kwak.test.data.WeekCommend;

public class MainFragment extends Fragment {

    RecyclerView listview;
    MainListAdapter mAdapter;

    private OnMainFragmentSelectListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        listview = (RecyclerView)view.findViewById(R.id.rv_list);

        mAdapter = new MainListAdapter(getFragmentManager(),getContext());

        listview.setAdapter(mAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listview.setLayoutManager(manager);
        mAdapter.setOnAdapterItemClickListener(new MainListAdapter.OnAdapterItemClickLIstener() {
            @Override
            public void onAdapterItemClick(View view, ImageData imageData) {
                Intent intent = new Intent(getContext(), ContentActivity.class);
                startActivity(intent);
            }
        });
        initData();
        return view;
    }

    public interface OnMainFragmentSelectListener {
        // TODO: Update argument type and name
        void onMainFragmentSelectListner(View view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void initData() {
        MainData mainData = new MainData();
//        Drawable[] image = {ContextCompat.getDrawable(this,R.drawable.test), ContextCompat.getDrawable(this,R.drawable.test),ContextCompat.getDrawable(this,R.drawable.test)};
        mainData.setUserName("KKH");

        SearchImage searchImage = new SearchImage();

        ImageData imageData = new ImageData();
        imageData.setImageId(R.drawable.roma);
        imageData.setImageName("로마");
        searchImage.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.seoul);
        imageData.setImageName("서울");
        searchImage.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.london);
        imageData.setImageName("런던");
        searchImage.getImageDatas().add(imageData);

        mainData.setSearchImage(searchImage);


        WeekCommend weekCommend = new WeekCommend();

        imageData = new ImageData();
        imageData.setImageId(R.drawable.bangkok);
        imageData.setImageName("방콕");
        weekCommend.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.osaka);
        imageData.setImageName("오사카");
        weekCommend.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.pari);
        imageData.setImageName("파리");
        weekCommend.getImageDatas().add(imageData);

        mainData.setWeekCommend(weekCommend);

        AirBnBCommend airBnBCommend = new AirBnBCommend();

        imageData = new ImageData();
        imageData.setImageId(R.drawable.smellslikeeamessspirit);
        imageData.setImageName("Shipping Containers");
        airBnBCommend.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.teslachargers);
        imageData.setImageName("Horse Ranches");
        airBnBCommend.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.smellslikeeamessspirit);
        imageData.setImageName("Milano Design");
        airBnBCommend.getImageDatas().add(imageData);

        mainData.setAirBnBCommend(airBnBCommend);

        PopularData popularData = new PopularData();

        imageData = new ImageData();
        imageData.setImageId(R.drawable.madrid);
        imageData.setImageName("마드리드");
        popularData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.banis);
        imageData.setImageName("베니스");
        popularData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.milano);
        imageData.setImageName("밀라노");
        popularData.getImageDatas().add(imageData);

        mainData.setPopularData(popularData);

        GuideData guideData = new GuideData();

        imageData = new ImageData();
        imageData.setImageId(R.drawable.sanfran);
        imageData.setImageName("샌프란시스코");
        guideData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.nuyok);
        imageData.setImageName("뉴욕");
        guideData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.randon2);
        imageData.setImageName("런던");
        guideData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.paris2);
        imageData.setImageName("파리");
        guideData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.balen);
        imageData.setImageName("베를린");
        guideData.getImageDatas().add(imageData);
        imageData = new ImageData();
        imageData.setImageId(R.drawable.los);
        imageData.setImageName("로스엔젤레스");
        guideData.getImageDatas().add(imageData);

        mainData.setGuideData(guideData);

        HostCommend hostCommend = new HostCommend();
        hostCommend.setImage(ContextCompat.getDrawable(getContext(),R.drawable.test));
        hostCommend.setRecomendText("여유 공간을 임대하여 수입을 올리세요.");
        mainData.setHostCommend(hostCommend);

        hostCommend = new HostCommend();
        hostCommend.setImage(ContextCompat.getDrawable(getContext(),R.drawable.test2));
        hostCommend.setRecomendText("여행 크레딧을 받으세요!.");
        mainData.setHostCommend2(hostCommend);

        mAdapter.setmainData(mainData);
    }
}
