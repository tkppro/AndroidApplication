package sourcecode.thangdang.viewpager;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment implements View.OnClickListener{


    public TabFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView (View view){
        TextView tv = view.findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }

    private void changeFragment(){
        getFragmentManager().beginTransaction().replace(R.id.activity_main,new TabFragment2()).addToBackStack(null).commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv:
                changeFragment();
                break;
        }
    }
}
