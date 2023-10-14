package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import android.view.View;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    FragmentManager fm;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fm = getSupportFragmentManager();

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);


        initial();
        fragmenthide();
        fragmentshow(fragment1);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }
    private void fragmenthide() {
        FragmentTransaction ft = fm.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        ft.commit();
    }

    public void initial() {
        FragmentTransaction ft = fm.beginTransaction()
                .add(R.id.content,fragment1)
                .add(R.id.content,fragment2)
                .add(R.id.content,fragment3)
                .add(R.id.content,fragment4);
        ft.commit();

    }

    @Override
    public void onClick(View view) {
        fragmenthide();
        if (view.getId()==R.id.linearLayout1)
            fragmentshow(fragment1);
        else if (view.getId()==R.id.linearLayout2)
            fragmentshow(fragment2);
        else if (view.getId()==R.id.linearLayout3)
            fragmentshow(fragment3);
        else if(view.getId()==R.id.linearLayout4)
            fragmentshow(fragment4);

    }

    public void fragmentshow(Fragment fragment) {

        FragmentTransaction transaction = fm.beginTransaction()
                .show(fragment);
        transaction.commit();
    }
}


