package app.com.example.android.givit_android.view.fragments;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import app.com.example.android.givit_android.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BrowsingFragment extends Fragment {

    @BindView(R.id.home_item_photo)
    ImageView homePhoto;
    @BindView(R.id.home_item_scroll)
    ScrollView homeScroll;
    @BindView(R.id.button_open_owner)
    ImageView openButton;
    @BindView(R.id.button_close_owner)
    ImageView closeButton;

    protected View rootView;

    public BrowsingFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browsing, container, false);
        this.rootView = view;
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initImageLayout();
    }

    private void initImageLayout(){
        WindowManager wm = (WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int height = display.getHeight();
        homePhoto.getLayoutParams().height = height*1/2;
        //pictureView.setAdjustViewBounds(true);
    }

    @OnClick(R.id.button_open_owner)
    public void onClickOpenOwner(){
        View itemOwner = (View) getActivity().findViewById(R.id.home_item_owner);
        itemOwner.setVisibility(View.VISIBLE);
        openButton.setVisibility(View.GONE);
        closeButton.setVisibility(View.VISIBLE);
        homeScroll.getLayoutParams().height = rootView.getHeight();;
    }

    @OnClick(R.id.button_close_owner)
    public void onClickCloseOwner(){
        View itemOwner = (View) getActivity().findViewById(R.id.home_item_owner);
        itemOwner.setVisibility(View.GONE);
        closeButton.setVisibility(View.GONE);
        openButton.setVisibility(View.VISIBLE);
        homeScroll.getLayoutParams().height = 0;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
