package tay.fun.outsmartroulette;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;

public class info extends AppCompatActivity {
    private ViewPager viewpager;
    private Adapter2 myadapter;
    Context context;
    TableLayout tbl;
    public Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);


        viewpager = (ViewPager) findViewById(R.id.vp);
        myadapter = new Adapter2(this);
        viewpager.setAdapter(myadapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);


    }


}
