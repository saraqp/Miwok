/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package quesado.prado.saramaria.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import quesado.prado.saramaria.miwok.R;
import quesado.prado.saramaria.miwok.adapter.MiwokViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    public NumbersClickListener clickListener;
    public TextView numberTextView,familyTextView,colorTextView,phraseTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TabLayout tablayout= (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager= (ViewPager) findViewById(R.id.pager_view);

        MiwokViewPagerAdapter pagerAdapter=new MiwokViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tablayout.setupWithViewPager(viewPager);
        /*
        //Forma 1 de hacer intent (en el caso de que vayas a usar el Listener desde varias vistas)
        clickListener=new NumbersClickListener();
        numberTextView= (TextView) findViewById(R.id.numbers);
        numberTextView.setOnClickListener(clickListener);
        //Forma 2 de hacer intent
        familyTextView= (TextView) findViewById(R.id.family);
        familyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),FamilyActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        colorTextView= (TextView) findViewById(R.id.colors);
        colorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),ColorActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        phraseTextview= (TextView) findViewById(R.id.phrases);
        phraseTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),PhraseActivity.class);
                v.getContext().startActivity(intent);
            }
        });
         */

    }
}
