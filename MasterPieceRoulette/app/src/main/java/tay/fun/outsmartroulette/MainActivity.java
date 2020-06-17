package tay.fun.outsmartroulette;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bentry, del;
    static int bb = 0;
    static int ib = 0;
    static int ub = 0;
    static int bs = 0;
    static int is = 0;
    static int us = 0;
    static int[] Vosin = new int[]{22, 18, 29, 7, 28, 12, 35, 3, 26, 0, 32, 15, 19, 4, 21, 2, 25};
    static int[] Ti = new int[]{33, 16, 24, 5, 10, 23, 8, 30, 11, 36, 13, 27};
    static int[] Orp = new int[]{17, 34, 6, 9, 31, 14, 20, 1};
    static int VosinNum = 0;
    static int TierNum = 0;
    static int OrphNum = 0;
    ArrayList<Integer> bb2 = new ArrayList<Integer>();
    ArrayList<Integer> ib2 = new ArrayList<Integer>();
    ArrayList<Integer> ub2 = new ArrayList<Integer>();
    ArrayList<Integer> bs2 = new ArrayList<Integer>();
    ArrayList<Integer> is2 = new ArrayList<Integer>();
    ArrayList<Integer> us2 = new ArrayList<Integer>();
    static int[] Vosin2 = new int[]{22, 18, 29, 7, 28, 12, 35, 3, 26, 0, 32, 15, 19, 4, 21, 2, 25};
    static int[] Ti2 = new int[]{33, 16, 24, 5, 10, 23, 8, 30, 11, 36, 13, 27};
    static int[] Orp2 = new int[]{17, 34, 6, 9, 31, 14, 20, 1};
    ArrayList<Integer> VosinNum2 = new ArrayList<Integer>();
    ArrayList<Integer> TierNum2 = new ArrayList<Integer>();
    ArrayList<Integer> OrphNum2 = new ArrayList<Integer>();
    //static int[] kirmizi1 = new int[]{7, 12, 3, 32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18};
    static int[] siyah1 = new int[]{29, 28, 35, 26, 15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22};

    public TextView T1, o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, t2t1,
            t2t2, t2t3, t2t4, t2t5, t2t6, t2t7, t2t8, t2t9, t2t10, t2t11, t2t12, t2t13, t2t14, t2t15, t2t16, t2t17, t2t18;
    public ImageView img, img2, img3;
    RelativeLayout relativeLayout;
    public static ArrayList<Integer> gelenler = new ArrayList<Integer>();
    ArrayList<Integer> gelenlerters = new ArrayList<Integer>();
    ArrayList<Integer> gelenlerters2 = new ArrayList<Integer>();
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idler();
        tesla();
        scale();
        nav.setNavigationItemSelectedListener(this);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav.setVisibility(View.VISIBLE);
            }
        });
        nav.getMenu().setGroupCheckable(0, false, true);

        bentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {

                } else {
                    buton(Integer.parseInt(T1.getText().toString()));
                }
            }
        });


    }

    public void idler() {
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        b0 = findViewById(R.id.btn0);
        bentry = findViewById(R.id.btnenter);
        T1 = findViewById(R.id.Entry);
        o1 = findViewById(R.id.o1);
        o2 = findViewById(R.id.o2);
        o3 = findViewById(R.id.o3);
        o4 = findViewById(R.id.o4);
        o5 = findViewById(R.id.o5);
        o6 = findViewById(R.id.o6);
        o7 = findViewById(R.id.o7);
        o8 = findViewById(R.id.o8);
        o9 = findViewById(R.id.o9);
        o10 = findViewById(R.id.o10);
        img = findViewById(R.id.imw);
        del = findViewById(R.id.del);
        t2t1 = findViewById(R.id.t2t1);
        t2t2 = findViewById(R.id.t2t2);
        t2t3 = findViewById(R.id.t2t3);
        t2t4 = findViewById(R.id.t2t4);
        t2t5 = findViewById(R.id.t2t5);
        t2t6 = findViewById(R.id.t2t6);
        t2t7 = findViewById(R.id.t2t7);
        t2t8 = findViewById(R.id.t2t8);
        t2t9 = findViewById(R.id.t2t9);
        t2t10 = findViewById(R.id.textView13);
        t2t11 = findViewById(R.id.textView14);
        t2t12 = findViewById(R.id.textView15);
        t2t13 = findViewById(R.id.textView16);
        t2t14 = findViewById(R.id.textView17);
        t2t15 = findViewById(R.id.textView18);
        t2t16 = findViewById(R.id.textView19);
        t2t17 = findViewById(R.id.textView20);
        t2t18 = findViewById(R.id.textView21);
        img2 = findViewById(R.id.img2);
        relativeLayout = findViewById(R.id.rlt1);
        img3 = findViewById(R.id.imageView2);
        nav = findViewById(R.id.nav);


    }

    public void tesla() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int deviceHeight = metrics.heightPixels;
        float pertext = (float) 15 / 1793;
        int a = (int) (deviceHeight * pertext);
        if (a < 12) {
            a = 12;
        }
        final int d = a;


        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("1");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "1");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("2");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "2");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("3");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "3");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b4.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("4");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "4");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b5.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("5");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "5");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b6.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("6");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "6");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b7.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("7");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "7");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b8.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("8");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "8");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b9.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("9");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "9");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        b0.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (T1.getText().toString().equals("")) {
                    T1.setText("0");
                    T1.setTextSize((float) (d * 1.5));
                } else if (((Integer.parseInt(T1.getText().toString()) > 0) && (Integer.parseInt(T1.getText().toString()) <= 9))) {
                    T1.setText(T1.getText().toString() + "0");
                    T1.setTextSize((float) (d * 1.5));
                }
            }

        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1.setText("");
            }
        });
        T1.setTextSize(d);
    }

    public void buton(int gelen) {
        if ((gelen >= 0) && (gelen <= 36)) {
            display(gelen);


            gelenler.add(gelen);

            tablo2();


        } else {
            Toast.makeText(getApplicationContext(), "Wrong Input", Toast.LENGTH_SHORT).show();
            T1.setText("");
        }

    }

    public void display(int gelen) {
        if ((gelen >= 0) && (gelen <= 36)) {
            o10.setText(o9.getText());
            o9.setText(o8.getText());
            o8.setText(o7.getText());
            o7.setText(o6.getText());
            o6.setText(o5.getText());
            o5.setText(o4.getText());
            o4.setText(o3.getText());
            o3.setText(o2.getText());
            o2.setText(o1.getText());
            o1.setText(String.valueOf(gelen));
            T1.setText("");
            if (o1.getText() != "") {
                if (Integer.parseInt(o1.getText().toString()) == 0) {
                    o1.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((Integer.parseInt(o1.getText().toString()) == value)) {
                            o1.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            o1.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
            }
            if (o2.getText().toString().matches("")) {
            } else {
                if (o2.getText() != "") {

                    if (Integer.parseInt(o2.getText().toString()) == 0) {
                        o2.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o2.getText().toString()) == value)) {
                                o2.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o2.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o3.getText().toString().matches("")) {
            } else {
                if (o3.getText() != "") {
                    if (Integer.parseInt(o3.getText().toString()) == 0) {
                        o3.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o3.getText().toString()) == value)) {
                                o3.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o3.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o4.getText().toString().matches("")) {
            } else {
                if (o4.getText() != "") {
                    if (Integer.parseInt(o4.getText().toString()) == 0) {
                        o4.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o4.getText().toString()) == value)) {
                                o4.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o4.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o5.getText().toString().matches("")) {
            } else {
                if (o5.getText() != "") {
                    if (Integer.parseInt(o5.getText().toString()) == 0) {
                        o5.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o5.getText().toString()) == value)) {
                                o5.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o5.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o6.getText().toString().matches("")) {
            } else {
                if (o6.getText() != "") {
                    if (Integer.parseInt(o6.getText().toString()) == 0) {
                        o6.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o6.getText().toString()) == value)) {
                                o6.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o6.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o7.getText().toString().matches("")) {
            } else {
                if (o7.getText() != "") {
                    if (Integer.parseInt(o7.getText().toString()) == 0) {
                        o7.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o7.getText().toString()) == value)) {
                                o7.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o7.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o8.getText().toString().matches("")) {
            } else {
                if (o8.getText() != "") {
                    if (Integer.parseInt(o8.getText().toString()) == 0) {
                        o8.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o8.getText().toString()) == value)) {
                                o8.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o8.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o9.getText().toString().matches("")) {
            } else {
                if (o9.getText() != "") {
                    if (Integer.parseInt(o9.getText().toString()) == 0) {
                        o9.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o9.getText().toString()) == value)) {
                                o9.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o9.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
            if (o10.getText().toString().matches("")) {
            } else {
                if (o10.getText() != "") {
                    if (Integer.parseInt(o10.getText().toString()) == 0) {
                        o10.setTextColor(this.getResources().getColor(R.color.green));
                    } else {
                        for (int value : siyah1)
                            if ((Integer.parseInt(o10.getText().toString()) == value)) {
                                o10.setTextColor(this.getResources().getColor(R.color.black));
                                break;
                            } else {
                                o10.setTextColor(this.getResources().getColor(R.color.red));

                            }
                    }
                }
            }
        }


    }

    public int[] statistics() {
        bb = 0;
        ib = 0;
        ub = 0;
        bs = 0;
        is = 0;
        us = 0;
        VosinNum = 0;
        TierNum = 0;
        OrphNum = 0;
        int size = gelenler.size();
        for (int i = 0; i < size; i++) {
            if ((gelenler.get(i) > 0) && (gelenler.get(i) < 13)) {
                bb = 0;
                ib = ib + 1;
                ub = ub + 1;

            } else if ((gelenler.get(i) > 12) && (gelenler.get(i) < 25)) {
                ib = 0;
                bb = bb + 1;
                ub = ub + 1;

            } else if ((gelenler.get(i) > 24) && ((gelenler.get(i) < 37))) {
                ub = 0;
                ib = ib + 1;
                bb = bb + 1;

            } else if ((gelenler.get(i) == 0)) {
                ub = ub + 1;
                ib = ib + 1;
                bb = bb + 1;

            }

            if ((gelenler.get(i) % 3 == 1)) {
                bs = 0;
                is = is + 1;
                us = us + 1;

            } else if ((gelenler.get(i) % 3 == 2)) {
                is = 0;
                bs = bs + 1;
                us = us + 1;

            } else if ((gelenler.get(i) > 0) && (gelenler.get(i) % 3 == 0)) {
                us = 0;
                is = is + 1;
                bs = bs + 1;

            } else if (gelenler.get(i) == 0) {
                us = us + 1;
                is = is + 1;
                bs = bs + 1;


            }
            for (int value : Vosin) {
                if (gelenler.get(i) == value) {
                    VosinNum = 0;
                    TierNum = TierNum + 1;
                    OrphNum = OrphNum + 1;

                    break;
                }
            }
            for (int value : Ti) {
                if (gelenler.get(i) == value) {
                    VosinNum = VosinNum + 1;
                    TierNum = 0;
                    OrphNum = OrphNum + 1;

                    break;
                }
            }
            for (int value : Orp) {
                if (gelenler.get(i) == value) {
                    VosinNum = VosinNum + 1;
                    TierNum = TierNum + 1;
                    OrphNum = 0;

                    break;


                }
            }
        }

        return new int[]{bb, ib, ub, bs, is, us, VosinNum, TierNum, OrphNum};
    }

    /*public int[][] statistics2() {


        int size = gelenler.size();
        for (int i = 0; i < size; i++) {
            if ((gelenler.get(i) > 0) && (gelenler.get(i) < 13)) {
                bb2.add(0);
                ib2 = ib2 + 1;
                ub2 = ub2 + 1;

            } else if ((gelenler.get(i) > 12) && (gelenler.get(i) < 25)) {
                ib2 = 0;
                bb2 = bb2 + 1;
                ub2 = ub2 + 1;

            } else if ((gelenler.get(i) > 24) && (gelenler.get(i) < 37)) {
                ub2 = 0;
                ib2 = ib2 + 1;
                bb2 = bb2 + 1;

            } else if (gelenler.get(i) == 0) {
                ub2 = ub2 + 1;
                ib2 = ib2 + 1;
                bb2 = bb2 + 1;

            }

            if ((gelenler.get(i) % 3 == 1)) {
                bs2 = 0;
                is2 = is2 + 1;
                us2 = us2 + 1;

            } else if ((gelenler.get(i) % 3 == 2)) {
                is2 = 0;
                bs2 = bs2 + 1;
                us2 = us2 + 1;

            } else if ((gelenler.get(i) > 0) && (gelenler.get(i) % 3 == 0)) {
                us2 = 0;
                is2 = is2 + 1;
                bs2 = bs2 + 1;

            } else if (gelenler.get(i) == 0) {
                us2 = us2 + 1;
                is2 = is2 + 1;
                bs2 = bs2 + 1;


            }
            for (int value : Vosin2) {
                if (gelenler.get(i) == value) {
                    VosinNum2 = 0;
                    TierNum2 = TierNum2 + 1;
                    OrphNum2 = OrphNum2 + 1;

                    break;
                }
            }
            for (int value : Ti2) {
                if (gelenler.get(i) == value) {
                    VosinNum2 = VosinNum2 + 1;
                    TierNum2 = 0;
                    OrphNum2 = OrphNum2 + 1;

                    break;
                }
            }
            for (int value : Orp2) {
                if (gelenler.get(i) == value) {
                    VosinNum2 = VosinNum2 + 1;
                    TierNum2 = TierNum2 + 1;
                    OrphNum2 = 0;

                    break;


                }
            }
        }

        return new int[][]{bb2, ib2, ub2, bs2, is2, us2, VosinNum2, TierNum2, OrphNum2};
    }
*/
    /*public void tablo (){
        bb2.clear();
        ib2.clear();
        ub2.clear();
        bs2.clear();is2.clear();us2.clear();VosinNum2.clear();TierNum2.clear();OrphNum2.clear();




        TableLayout stk = findViewById(R.id.table_main);
        int childCount = stk.getChildCount();

        // Remove all rows except the first one
        if (childCount > 1) {
            stk.removeViews(1, childCount - 1);
        }


        int size = gelenler.size();
        for (int i = 0; i < size; i++) {
            if ((gelenler.get(i) > 0) && (gelenler.get(i) < 13)) {
                bb2.add(0);
                if(ib2.size()==0){
                ib2.add(1);}
                else{ib2.add(ib2.get(i-1)+1);}
                if(ub2.size()==0){
                    ub2.add(1);}else{ub2.add(ub2.get(i-1)+1);}


            } else if ((gelenler.get(i) > 12) && (gelenler.get(i) < 25)) {
                ib2.add(0);
                if(bb2.size()==0){
                    bb2.add(1);}else{bb2.add(bb2.get(i-1)+1);}
                if(ub2.size()==0){
                    ub2.add(1);}else{ub2.add(ub2.get(i-1)+1);}

            } else if ((gelenler.get(i) > 24) && (gelenler.get(i) < 37)) {
                ub2.add(0);
                if(bb2.size()==0){
                    bb2.add(1);}else{bb2.add(bb2.get(i-1)+1);}
                if(ib2.size()==0){
                    ib2.add(1);}else{ib2.add(ib2.get(i-1)+1);}

            } else if (gelenler.get(i) == 0) {
                if(bb2.size()==0){
                    bb2.add(1);}else{bb2.add(bb2.get(i-1)+1);}
                if(ib2.size()==0){
                    ib2.add(1);}else{ib2.add(ib2.get(i-1)+1);}
                if(ub2.size()==0){
                    ub2.add(1);}else{ub2.add(ub2.get(i-1)+1);}
            }

            if ((gelenler.get(i) % 3 == 1)) {
                bs2.add(0);
                if(is2.size()==0){
                    is2.add(1);}else{is2.add(is2.get(i-1)+1);}
                if(us2.size()==0){
                    us2.add(1);}else{us2.add(us2.get(i-1)+1);}

            } else if ((gelenler.get(i) % 3 == 2)) {
                is2.add(0);
                if(bs2.size()==0){
                    bs2.add(1);}else{bs2.add(bs2.get(i-1)+1);}
                if(us2.size()==0){
                    us2.add(1);}else{us2.add(us2.get(i-1)+1);}

            } else if ((gelenler.get(i) > 0) && (gelenler.get(i) % 3 == 0)) {
                us2.add(0);
                if(is2.size()==0){
                    is2.add(1);}else{is2.add(is2.get(i-1)+1);}
                if(bs2.size()==0){
                    bs2.add(1);}else{bs2.add(bs2.get(i-1)+1);}

            } else if (gelenler.get(i) == 0) {
                if(us2.size()==0){
                    us2.add(1);}else{us2.add(us2.get(i-1)+1);}
                if(is2.size()==0){
                    is2.add(1);}else{is2.add(is2.get(i-1)+1);}
                if(bs2.size()==0){
                    bs2.add(1);}else{bs2.add(bs2.get(i-1)+1);}

            }
            for (int value : Vosin2) {
                if (gelenler.get(i) == value) {
                    VosinNum2.add(0);
                    if(TierNum2.size()==0){
                        TierNum2.add(1);}else{TierNum2.add(TierNum2.get(i-1)+1);}
                    if(OrphNum2.size()==0){
                        OrphNum2.add(1);}else{OrphNum2.add(OrphNum2.get(i-1)+1);}

                    break;
                }
            }
            for (int value : Ti2) {
                if (gelenler.get(i) == value) {
                    TierNum2.add(0);
                    if(VosinNum2.size()==0){
                        VosinNum2.add(1);}else{VosinNum2.add(VosinNum2.get(i-1)+1);}
                    if(OrphNum2.size()==0){
                        OrphNum2.add(1);}else{OrphNum2.add(OrphNum2.get(i-1)+1);}


                    break;
                }
            }
            for (int value : Orp2) {
                if (gelenler.get(i) == value) {
                   OrphNum2.add(0);
                    if(TierNum2.size()==0){
                        TierNum2.add(1);}else{TierNum2.add(TierNum2.get(i-1)+1);}
                    if(VosinNum2.size()==0){
                        VosinNum2.add(1);}else{VosinNum2.add(VosinNum2.get(i-1)+1);}


                    break;


                }
            }
        }








        for(int i=1;i<=size;i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText(String.valueOf(i));
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setBackgroundResource(R.drawable.border311);
            t1v.setTextSize(10);
            t1v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            t1v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            tbrow.addView(t1v);

            if (bb2.get(i-1) == 0) {
                TextView t2v = new TextView(this);
                t2v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t2v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t2v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t2v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }

                t2v.setGravity(Gravity.CENTER);
                t2v.setBackgroundResource(R.drawable.border4);
                t2v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t2v.setTextSize(10);
                t2v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t2v);
            } else {
                TextView t2v = new TextView(this);
                t2v.setText("");
                t2v.setTextColor(Color.BLACK);
                t2v.setGravity(Gravity.CENTER);
                t2v.setTextSize(10);
                t2v.setBackgroundResource(R.drawable.border4);
                t2v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t2v);
            }
            if (ib2.get(i-1) == 0) {
                TextView t3v = new TextView(this);
                t3v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t3v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t3v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t3v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t3v.setGravity(Gravity.CENTER);
                t3v.setTextSize(10);
                t3v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t3v.setBackgroundResource(R.drawable.border311);
                t3v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t3v);
            } else {
                TextView t3v = new TextView(this);
                t3v.setText("");
                t3v.setTextColor(Color.BLACK);
                t3v.setGravity(Gravity.CENTER);
                t3v.setTextSize(10);
                t3v.setBackgroundResource(R.drawable.border311);
                t3v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t3v);

            }
            if (ub2.get(i-1) == 0) {
                TextView t4v = new TextView(this);
                t4v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t4v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t4v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t4v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t4v.setGravity(Gravity.CENTER);
                t4v.setTextSize(10);
                t4v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t4v.setBackgroundResource(R.drawable.border4);
                t4v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t4v);
            } else {
                TextView t4v = new TextView(this);
                t4v.setText("");
                t4v.setTextColor(Color.BLACK);
                t4v.setGravity(Gravity.CENTER);
                t4v.setTextSize(10);
                t4v.setBackgroundResource(R.drawable.border4);
                t4v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t4v);

            }
            if (bs2.get(i-1)== 0) {
                TextView t5v = new TextView(this);
                t5v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t5v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1)== value)) {
                            t5v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t5v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t5v.setGravity(Gravity.CENTER);
                t5v.setTextSize(10);
                t5v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t5v.setBackgroundResource(R.drawable.border311);
                t5v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t5v);
            } else {
                TextView t5v = new TextView(this);
                t5v.setText("");
                t5v.setTextColor(Color.BLACK);
                t5v.setGravity(Gravity.CENTER);
                t5v.setTextSize(10);
                t5v.setBackgroundResource(R.drawable.border311);
                t5v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t5v);

            }
            if (is2.get(i-1) == 0) {
                TextView t6v = new TextView(this);
                t6v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t6v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1)== value)) {
                            t6v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t6v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t6v.setGravity(Gravity.CENTER);
                t6v.setTextSize(10);
                t6v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t6v.setBackgroundResource(R.drawable.border4);
                t6v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t6v);
            } else {
                TextView t6v = new TextView(this);
                t6v.setText("");
                t6v.setTextColor(Color.BLACK);
                t6v.setGravity(Gravity.CENTER);
                t6v.setTextSize(10);
                t6v.setBackgroundResource(R.drawable.border4);
                t6v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t6v);

            }
            if (us2.get(i-1) == 0) {
                TextView t7v = new TextView(this);
                t7v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t7v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t7v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t7v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t7v.setGravity(Gravity.CENTER);
                t7v.setTextSize(10);
                t7v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t7v.setBackgroundResource(R.drawable.border311);
                t7v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t7v);
            } else {
                TextView t7v = new TextView(this);
                t7v.setText("");
                t7v.setTextColor(Color.BLACK);
                t7v.setGravity(Gravity.CENTER);
                t7v.setTextSize(10);
                t7v.setBackgroundResource(R.drawable.border311);
                t7v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t7v);

            }
            if (VosinNum2.get(i-1) == 0) {
                TextView t8v = new TextView(this);
                t8v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t8v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t8v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t8v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t8v.setGravity(Gravity.CENTER);
                t8v.setTextSize(10);
                t8v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t8v.setBackgroundResource(R.drawable.border4);
                t8v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t8v);
            } else {
                TextView t8v = new TextView(this);
                t8v.setText("");
                t8v.setTextColor(Color.BLACK);
                t8v.setGravity(Gravity.CENTER);
                t8v.setTextSize(10);
                t8v.setBackgroundResource(R.drawable.border4);
                t8v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t8v);

            }
            if (TierNum2.get(i-1)== 0) {
                TextView t9v = new TextView(this);
                t9v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1) == 0) {
                    t9v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t9v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t9v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t9v.setGravity(Gravity.CENTER);
                t9v.setTextSize(10);
                t9v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t9v.setBackgroundResource(R.drawable.border311);
                t9v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t9v);
            } else {
                TextView t9v = new TextView(this);
                t9v.setText("");
                t9v.setGravity(Gravity.CENTER);
                t9v.setTextSize(10);
                t9v.setBackgroundResource(R.drawable.border311);
                t9v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t9v);

            }
            if (OrphNum2.get(i-1) == 0) {
                TextView t10v = new TextView(this);
                t10v.setText(String.valueOf(gelenler.get(i-1)));
                if (gelenler.get(i-1)== 0) {
                    t10v.setTextColor(this.getResources().getColor(R.color.green));
                } else {
                    for (int value : siyah1)
                        if ((gelenler.get(i-1) == value)) {
                            t10v.setTextColor(this.getResources().getColor(R.color.black));
                            break;
                        } else {
                            t10v.setTextColor(this.getResources().getColor(R.color.red));

                        }
                }
                t10v.setGravity(Gravity.CENTER);
                t10v.setTextSize(10);
                t10v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t10v.setBackgroundResource(R.drawable.border4);
                t10v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t10v);
            } else {
                TextView t10v = new TextView(this);
                t10v.setText("");
                t10v.setTextColor(Color.BLACK);
                t10v.setGravity(Gravity.CENTER);
                t10v.setTextSize(10);

                t10v.setBackgroundResource(R.drawable.border4);
                t10v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                tbrow.addView(t10v);

            }
            stk.addView(tbrow,1);


        }

    }*/

    public void tablo2() {
        int[] stats = statistics();
        TextView[] aaa = new TextView[]{t2t1, t2t2, t2t3, t2t4, t2t5, t2t6, t2t7, t2t8, t2t9};
        for (int j = 0; j < 9; j++) {
            if (stats[j] >= 4) {
                aaa[j].setText(String.valueOf(stats[j]));
                aaa[j].setTextColor(getResources().getColor(R.color.bok));
            } else {
                aaa[j].setText(String.valueOf(stats[j]));
                aaa[j].setTextColor(getResources().getColor(R.color.black));
            }
        }
        if ((stats[6] >= 8)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.vosin8));
        } else if ((stats[7] >= 10)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.tier10));
        } else if ((stats[8] >= 15)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.orph15));
        } else if ((stats[0] >= 4) && (stats[1] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bb4ib4));
        } else if ((stats[0] >= 4) && (stats[2] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bb4ub4));
        } else if ((stats[1] >= 4) && (stats[2] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib4ub4));
        } else if ((stats[3] >= 4) && (stats[4] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bs4is4));
        } else if ((stats[3] >= 4) && (stats[5] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bs4us4));
        } else if ((stats[4] >= 4) && (stats[5] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.is4us4));
        } else if ((stats[1] >= 3) && (stats[3] >= 3) && (stats[6] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3bs3vos2));
        } else if ((stats[1] >= 3) && (stats[3] >= 3) && (stats[7] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3bs3tier2));
        } else if ((stats[2] >= 3) && (stats[3] >= 3) && (stats[6] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub3bs3vos2));
        } else if ((stats[2] >= 3) && (stats[3] >= 3) && (stats[7] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3bs3tier2));
        } else if ((stats[2] >= 3) && (stats[3] >= 3)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub3bs3));
        } else if ((stats[1] >= 2) && (stats[3] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3bs3));
        } else if ((stats[1] >= 3) && (stats[6] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3v2));
        } else if ((stats[1] >= 3) && (stats[7] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3t2));
        } else if ((stats[3] >= 3) && (stats[6] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bs3v2));
        } else if ((stats[3] >= 3) && (stats[7] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bs3t2));
        } else if ((stats[2] >= 3) && (stats[6] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub3v2));
        } else if ((stats[2] >= 3) && (stats[7] >= 2)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub3t2));
        } else if ((stats[1] >= 3) && (stats[4] >= 3)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3is3));
        } else if ((stats[1] >= 3) && (stats[5] >= 3)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib3us3));
        } else if ((stats[0] >= 4) && (stats[3] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bb4bs4));
        } else if ((stats[0] >= 4) && (stats[4] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bb4is4));
        } else if ((stats[0] >= 3) && (stats[5] >= 3)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bb3us3));
        } else if ((stats[2] >= 3) && (stats[4] >= 3)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub3is3));
        } else if ((stats[2] >= 3) && (stats[5] >= 3)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub3us3));
        } else if ((stats[0] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bb4));
        } else if ((stats[1] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ib4));
        } else if ((stats[2] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.ub4));
        } else if ((stats[3] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bs4));
        } else if ((stats[4] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.bs4us4));
        } else if ((stats[5] >= 4)) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.us4));
        } else {

            img.setImageDrawable(getResources().getDrawable(R.drawable.main));
        }


    }

    public void information1(View view) {


        if ((view.getId() == R.id.textView21) || (view.getId() == R.id.t2t1)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.masabos));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
        if ((view.getId() == R.id.textView20) || (view.getId() == R.id.t2t2)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.masabos));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
        if ((view.getId() == R.id.textView19) || (view.getId() == R.id.t2t3)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.masabos));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
        if ((view.getId() == R.id.textView18) || (view.getId() == R.id.t2t4)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.masabos));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
        if ((view.getId() == R.id.textView17) || (view.getId() == R.id.t2t5)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.masabos));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
        if ((view.getId() == R.id.textView16) || (view.getId() == R.id.t2t6)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.masabos));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
        if ((view.getId() == R.id.textView15) || (view.getId() == R.id.textView14) || (view.getId() == R.id.textView13)
                || (view.getId() == R.id.t2t7) || (view.getId() == R.id.t2t8) || (view.getId() == R.id.t2t9)) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.tekerlek));
            img2.setVisibility(View.VISIBLE);
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    img2.setVisibility(View.GONE);
                }
            });
        }
    }

    public void scale() {
        int ddd = 0;
        TableRow table1 = findViewById(R.id.tbr1);
        RelativeLayout rlt1 = findViewById(R.id.rlt1);


        DisplayMetrics metrics = getResources().getDisplayMetrics();


        int deviceWidth = metrics.widthPixels;
        int deviceHeight = metrics.heightPixels;
        int a = (int) (deviceWidth * 0.1);
        int b = (int) (deviceHeight * 0.5);
        float perimg3 = (float) 100 / 1793;
        int c = (int) (deviceHeight * perimg3);
        TextView[] ber = new TextView[]{o1, o2, o3, o4, o5, o6, o7, o8, o9, o10};
        TextView[] bir = new TextView[]{t2t1,
                t2t2, t2t3, t2t4, t2t5, t2t6, t2t7, t2t8, t2t9, t2t10, t2t11, t2t12, t2t13, t2t14, t2t15, t2t16, t2t17, t2t18};

        Button[] bur = new Button[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bentry, del};
        table1.setLayoutParams(new TableRow.LayoutParams(a, b));
        img3.getLayoutParams().height = c;
        img3.getLayoutParams().width = c;
        //Toast.makeText(getApplicationContext(),String.valueOf(deviceWidth),Toast.LENGTH_LONG).show();
        for (TextView value : ber) {
            value.setLayoutParams(new TableRow.LayoutParams(a, b / 10));
            float pertext = (float) 20 / 1793;
            int d = (int) (deviceHeight * pertext);
            value.setTextColor(this.getResources().getColor(R.color.black));

            if (d < 13) {
                value.setTextSize(13);
            } else {
                value.setTextSize(d);
            }
            ddd = ddd + 1;
        }
        for (TextView value : bir) {

            float pertext = (float) 20 / 1793;
            int d = (int) (deviceHeight * pertext);
            value.setTextColor(this.getResources().getColor(R.color.black));
            if (d < 13) {
                value.setTextSize(13);
            } else {
                value.setTextSize(d);
            }
        }
        for (Button value : bur) {
            if ((value == b1) || (value == b6)) {
                float pertext = (float) 120 / 1793;
                int d = (int) (deviceHeight * pertext);
                value.setLayoutParams(new TableRow.LayoutParams(0, d, 6f));
            }

            float pertext = (float) 16 / 1080;
            int d = (int) (deviceWidth * pertext);
            value.setTextColor(this.getResources().getColor(R.color.black));
            if (d < 13) {
                value.setTextSize(13);
                value.setTextColor(this.getResources().getColor(R.color.black));

            } else {
                value.setTextSize(d);
                value.setTextColor(this.getResources().getColor(R.color.black));

            }
        }

    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(getApplicationContext(), "Yanlış Sayı Girdiniz", Toast.LENGTH_SHORT).show();
        if (nav.getVisibility() == View.VISIBLE) {
            nav.setVisibility(View.GONE);
        } else if (img2.getVisibility() == View.VISIBLE) {
            img2.setVisibility(View.GONE);
        } else {
            TextView[] displaydekiler = new TextView[]{o1, o2, o3, o4, o5, o6, o7, o8, o9, o10};
            int size1 = gelenler.size() - 1;
            gelenler.remove(size1);
            int size = gelenler.size() - 1;

            if (size == -1) {
                for(TextView value:displaydekiler){
                value.setText("");}
            } else {
                for (int i = size; i >= 0; i--) {
                    gelenlerters.add(gelenler.get(i));

                }
                //Toast.makeText(getApplicationContext(), String.valueOf(gelenlerters.get(0)), Toast.LENGTH_SHORT).show();

                final int a;
                if (gelenlerters.size() < 11) {
                    a = gelenlerters.size();
                } else {
                    a = 10;
                }

                for (int i = 0; i < a; i++) {

                    displaydekiler[i].setText(String.valueOf(gelenlerters.get(i)));
                    if(i+1<10){
                    displaydekiler[i + 1].setText("");}else{displaydekiler[i].setText("");}


                    if (displaydekiler[i].getText().toString().matches("")) {
                    } else {
                        if (displaydekiler[i].getText() != "") {

                            if (Integer.parseInt(displaydekiler[i].getText().toString()) == 0) {
                                displaydekiler[i].setTextColor(this.getResources().getColor(R.color.green));
                            } else {
                                for (int value : siyah1)
                                    if ((Integer.parseInt(displaydekiler[i].getText().toString()) == value)) {
                                        displaydekiler[i].setTextColor(this.getResources().getColor(R.color.black));
                                        break;
                                    } else {
                                        displaydekiler[i].setTextColor(this.getResources().getColor(R.color.red));

                                    }
                            }
                        }
                    }

                }
            }
            //super.onBackPressed();
            gelenlerters.clear();
            tablo2();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.information:

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);;
                startActivity(intent);

                break;
            case R.id.stats:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new statsclass()).commit();

                break;
            case R.id.back:
                nav.setVisibility(View.GONE);
        }

        nav.setVisibility(View.GONE);
        return true;
    }
}

