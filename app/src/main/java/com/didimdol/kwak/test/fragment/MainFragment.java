package com.didimdol.kwak.test.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.adapter.MainListAdapter;
import com.didimdol.kwak.test.data.AirBnBCommend;
import com.didimdol.kwak.test.data.HostCommend;
import com.didimdol.kwak.test.data.ImageData;
import com.didimdol.kwak.test.data.MainData;
import com.didimdol.kwak.test.data.SearchImage;
import com.didimdol.kwak.test.data.WeekCommend;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    RecyclerView listview;
    MainListAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        listview = (RecyclerView)view.findViewById(R.id.rv_list);

        mAdapter = new MainListAdapter(getFragmentManager(),getContext());

        listview.setAdapter(mAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listview.setLayoutManager(manager);
        initData();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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

        HostCommend hostCommend = new HostCommend();
        hostCommend.setImage(ContextCompat.getDrawable(getContext(),R.drawable.test));
        hostCommend.setRecomendText("여유 공간을 임대하여 수입을 올리세요.");
        mainData.setHostCommend(hostCommend);

        mAdapter.setmainData(mainData);
    }
}
