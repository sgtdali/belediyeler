package tay.fun.outsmartroulette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;


    public Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.layout_opening, container, false);
        View v = inflater.inflate(R.layout.layout_opening2, container, false);
        View v2 = inflater.inflate(R.layout.layout_opening3, container, false);

        if (position == 2) {


            ImageView btn= v2.findViewById(R.id.img5);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((Main2Activity)context).finish();
                }
            });
            container.addView(v2);
            return v2;
        } else if(position ==1){

            container.addView(v);
            return v;

        }else if(position ==0){

            container.addView(view1);
        } return view1;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);

    }



}
