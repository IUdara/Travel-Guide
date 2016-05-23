package com.travelsoft.lanka.travel_guide.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.travelsoft.lanka.travel_guide.R;
import com.travelsoft.lanka.travel_guide.adapters.GridViewAdapter;
import com.travelsoft.lanka.travel_guide.asynctasks.AsyncTaskGridViewLoader;
import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.models.Place;
import com.travelsoft.lanka.travel_guide.utils.Constants.GridCellType;
import com.travelsoft.lanka.travel_guide.utils.Constants.ItemSubTypeKey;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlacesHomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlacesHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesHomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private GridViewAdapter gridGridViewAdapter;
    private AsyncTaskGridViewLoader gridViewLoaderTask;

    public PlacesHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacesHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacesHomeFragment newInstance(String param1, String param2) {
        PlacesHomeFragment fragment = new PlacesHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_places_home, container, false);
        final GridView gridview = (GridView) fragmentView.findViewById(R.id.image_grid);
        gridview.setOnItemClickListener(this);
        gridGridViewAdapter = new GridViewAdapter(getContext());
        gridview.setAdapter(gridGridViewAdapter);
        gridViewLoaderTask = new AsyncTaskGridViewLoader(gridGridViewAdapter);
        gridViewLoaderTask.execute(GridCellType.PLACE_CATEGORY.realName(), ItemSubTypeKey.PLACE_CATEGORY_KEY.realValue(), "18");
        return fragmentView;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GridViewCell gridViewCell = (GridViewCell)parent.getItemAtPosition(position);
        String itemSubTypeValue = gridViewCell.getShortName(); // should replace "49"
        GridCellType gridCellType = gridViewCell.getCellType();

        ((GridViewAdapter) parent.getAdapter()).clear();

        switch (gridCellType){
            case PLACE_CATEGORY:{
                gridViewLoaderTask = new AsyncTaskGridViewLoader((GridViewAdapter)parent.getAdapter());
                gridViewLoaderTask.execute(GridCellType.PLACE.realName(), ItemSubTypeKey.PLACE_KEY.realValue(), "49");
                break;
            }
            case PLACE:{
                if (mListener != null) {
                    Fragment placeDetailsFragment = PlaceDetailsFragment.newInstance("PlaceDetailsFrag", (Place)gridViewCell);
                    mListener.onFragmentInteraction(placeDetailsFragment);
                }
                break;
            }
            default:{
                break;
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Fragment nextFragment);
    }
}
