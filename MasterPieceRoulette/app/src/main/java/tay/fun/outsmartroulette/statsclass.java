package tay.fun.outsmartroulette;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;


import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;


public class statsclass extends Fragment {
    MainActivity ma = new MainActivity();
    public  ArrayList<Integer> gelenler = ma.gelenler;
    ArrayList<Integer>  bb2 = new ArrayList<Integer>();
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
    static int[] siyah1 = new int[]{29, 28, 35, 26, 15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22};

    Context context;
    Fragment me = this;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.stats, container, false);
        TableLayout stk = view.findViewById(R.id.table_main);
        TableLayout stk3 = view.findViewById(R.id.table_main2);
        TableLayout stk2 = view.findViewById(R.id.table_main3);
        Button btn = view.findViewById(R.id.buton222);
        int textboyut = 15;
        final Fragment me = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                manager.getBackStackEntryCount();
                transaction.remove(me);
                transaction.commit();

            }});







        bb2.clear();
        ib2.clear();
        ub2.clear();
        bs2.clear();is2.clear();us2.clear();VosinNum2.clear();TierNum2.clear();OrphNum2.clear();





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
            TableRow tbrow = new TableRow(getActivity());
            TableRow tbrow2 = new TableRow(getActivity());
            TableRow tbrow3 = new TableRow(getActivity());
            TextView t1v = new TextView(getActivity());
            t1v.setText(String.valueOf(i));
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setBackgroundResource(R.drawable.border311);
            t1v.setTextSize(textboyut);
            t1v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            t1v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            tbrow.addView(t1v);
            TextView t20v = new TextView(getActivity());
            t20v.setText(String.valueOf(i));
            t20v.setTextColor(Color.BLACK);
            t20v.setGravity(Gravity.CENTER);
            t20v.setBackgroundResource(R.drawable.border311);
            t20v.setTextSize(textboyut);
            t20v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            t20v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            tbrow2.addView(t20v);
            TextView t30v = new TextView(getActivity());
            t30v.setText(String.valueOf(i));
            t30v.setTextColor(Color.BLACK);
            t30v.setGravity(Gravity.CENTER);
            t30v.setBackgroundResource(R.drawable.border311);
            t30v.setTextSize(textboyut);
            t30v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            t30v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            tbrow3.addView(t30v);
            if (bb2.get(i-1) == 0) {
                TextView t2v = new TextView(getActivity());
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
                t2v.setBackgroundResource(R.drawable.border411);
                t2v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t2v.setTextSize(textboyut);
                t2v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow.addView(t2v);
            } else {
                TextView t2v = new TextView(getActivity());
                t2v.setText("");
                t2v.setTextColor(Color.BLACK);
                t2v.setGravity(Gravity.CENTER);
                t2v.setTextSize(textboyut);
                t2v.setBackgroundResource(R.drawable.border411);
                t2v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow.addView(t2v);
            }
            if (ib2.get(i-1) == 0) {
                TextView t3v = new TextView(getActivity());
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
                t3v.setTextSize(textboyut);
                t3v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t3v.setBackgroundResource(R.drawable.border311);
                t3v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow.addView(t3v);
            } else {
                TextView t3v = new TextView(getActivity());
                t3v.setText("");
                t3v.setTextColor(Color.BLACK);
                t3v.setGravity(Gravity.CENTER);
                t3v.setTextSize(textboyut);
                t3v.setBackgroundResource(R.drawable.border311);
                t3v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow.addView(t3v);

            }
            if (ub2.get(i-1) == 0) {
                TextView t4v = new TextView(getActivity());
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
                t4v.setTextSize(textboyut);
                t4v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t4v.setBackgroundResource(R.drawable.border411);
                t4v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow.addView(t4v);
            } else {
                TextView t4v = new TextView(getActivity());
                t4v.setText("");
                t4v.setTextColor(Color.BLACK);
                t4v.setGravity(Gravity.CENTER);
                t4v.setTextSize(textboyut);
                t4v.setBackgroundResource(R.drawable.border411);
                t4v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow.addView(t4v);

            }
            if (bs2.get(i-1)== 0) {
                TextView t5v = new TextView(getActivity());
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
                t5v.setTextSize(textboyut);
                t5v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t5v.setBackgroundResource(R.drawable.border411);
                t5v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow2.addView(t5v);
            } else {
                TextView t5v = new TextView(getActivity());
                t5v.setText("");
                t5v.setTextColor(Color.BLACK);
                t5v.setGravity(Gravity.CENTER);
                t5v.setTextSize(textboyut);
                t5v.setBackgroundResource(R.drawable.border411);
                t5v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow2.addView(t5v);

            }
            if (is2.get(i-1) == 0) {
                TextView t6v = new TextView(getActivity());
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
                t6v.setTextSize(textboyut);
                t6v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t6v.setBackgroundResource(R.drawable.border311);
                t6v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow2.addView(t6v);
            } else {
                TextView t6v = new TextView(getActivity());
                t6v.setText("");
                t6v.setTextColor(Color.BLACK);
                t6v.setGravity(Gravity.CENTER);
                t6v.setTextSize(textboyut);
                t6v.setBackgroundResource(R.drawable.border311);
                t6v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow2.addView(t6v);

            }
            if (us2.get(i-1) == 0) {
                TextView t7v = new TextView(getActivity());
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
                t7v.setTextSize(textboyut);
                t7v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t7v.setBackgroundResource(R.drawable.border411);
                t7v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow2.addView(t7v);
            } else {
                TextView t7v = new TextView(getActivity());
                t7v.setText("");
                t7v.setTextColor(Color.BLACK);
                t7v.setGravity(Gravity.CENTER);
                t7v.setTextSize(textboyut);
                t7v.setBackgroundResource(R.drawable.border411);
                t7v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow2.addView(t7v);

            }
            if (VosinNum2.get(i-1) == 0) {
                TextView t8v = new TextView(getActivity());
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
                t8v.setTextSize(textboyut);
                t8v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t8v.setBackgroundResource(R.drawable.border411);
                t8v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow3.addView(t8v);
            } else {
                TextView t8v = new TextView(getActivity());
                t8v.setText("");
                t8v.setTextColor(Color.BLACK);
                t8v.setGravity(Gravity.CENTER);
                t8v.setTextSize(textboyut);
                t8v.setBackgroundResource(R.drawable.border411);
                t8v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow3.addView(t8v);

            }
            if (TierNum2.get(i-1)== 0) {
                TextView t9v = new TextView(getActivity());
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
                t9v.setTextSize(textboyut);
                t9v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t9v.setBackgroundResource(R.drawable.border311);
                t9v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow3.addView(t9v);
            } else {
                TextView t9v = new TextView(getActivity());
                t9v.setText("");
                t9v.setGravity(Gravity.CENTER);
                t9v.setTextSize(textboyut);
                t9v.setBackgroundResource(R.drawable.border311);
                t9v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow3.addView(t9v);

            }
            if (OrphNum2.get(i-1) == 0) {
                TextView t10v = new TextView(getActivity());
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
                t10v.setTextSize(textboyut);
                t10v.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                t10v.setBackgroundResource(R.drawable.border411);
                t10v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow3.addView(t10v);
            } else {
                TextView t10v = new TextView(getActivity());
                t10v.setText("");
                t10v.setTextColor(Color.BLACK);
                t10v.setGravity(Gravity.CENTER);
                t10v.setTextSize(textboyut);

                t10v.setBackgroundResource(R.drawable.border411);
                t10v.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
                tbrow3.addView(t10v);

            }
            stk.addView(tbrow, 1);
            stk2.addView(tbrow2, 1);
            stk3.addView(tbrow3, 1);
        }
        return view;
    }



}