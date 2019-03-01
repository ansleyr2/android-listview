package com.example.assignment2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    ImageView mSelectedImage;
    View  previousView;
    long previousPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list);
        mListView.setItemsCanFocus(false);

        List<AnimalListData> listData = new ArrayList<>();
        listData.add(new AnimalListData("ic_dog", "First item" ));
        listData.add(new AnimalListData("ic_tiger", "Second item" ));
        listData.add(new AnimalListData("ic_lion", "Third item" ));
        listData.add(new AnimalListData("ic_penguin", "Fourth item" ));
        listData.add(new AnimalListData("ic_chicken", "Fifth item" ));
        listData.add(new AnimalListData("ic_cow", "Sixth item" ));
        listData.add(new AnimalListData("ic_crab", "Seventh item" ));
        listData.add(new AnimalListData("ic_elephant", "Eight item" ));
        listData.add(new AnimalListData("ic_fox", "Ninth item" ));
        listData.add(new AnimalListData("ic_giraffe", "Tenth item" ));


        ExampleAdapter adapter = new ExampleAdapter(this, listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(id);
                System.out.println(position);
                Toast.makeText(MainActivity.this, "the row at position "+ position + "was clicked", Toast.LENGTH_LONG).show();

                //parent.findViewById(R.id.textView).setVisibility(View.INVISIBLE);
               /*if(previousView != null){
                    // Hide the text and buttons
                    previousView.findViewById(R.id.textView).setVisibility(View.INVISIBLE);
                    previousView.findViewById(R.id.nextAndDeleteFactLayout).setVisibility(View.INVISIBLE);
                }*/
                /*if(previousId != id){
                    //
                    view.findViewById(R.id.textView).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.nextAndDeleteFactLayout).setVisibility(View.VISIBLE);
                }*/
                if( previousPos > -1 && (previousPos != position) ){
                    // Hide the text and buttons
                    previousView.findViewById(R.id.textView).setVisibility(View.INVISIBLE);
                    previousView.findViewById(R.id.nextAndDeleteFactLayout).setVisibility(View.INVISIBLE);
                }

                view.findViewById(R.id.textView).setVisibility(
                        view.findViewById(R.id.textView).getVisibility() == View.VISIBLE? View.INVISIBLE : View.VISIBLE);
                view.findViewById(R.id.nextAndDeleteFactLayout).setVisibility(
                        view.findViewById(R.id.nextAndDeleteFactLayout).getVisibility() == View.VISIBLE? View.INVISIBLE: View.VISIBLE);
                //System.out.println(view.getId());

                mSelectedImage = view.findViewById(R.id.animalImage);
                previousView = view;
                previousPos = position;
                //adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.rotate).setOnClickListener(view -> {
             mSelectedImage.setRotation(mSelectedImage.getRotation() + 90);
        });

        findViewById(R.id.flip).setOnClickListener(view -> {
            mSelectedImage.setScaleX(mSelectedImage.getScaleX() * -1);
        });
    }
}
