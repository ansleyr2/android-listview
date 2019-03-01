package com.example.assignment2;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class ExampleAdapter extends BaseAdapter {
    Context mContext;
    List<AnimalListData> mListData;

    public ExampleAdapter(Context context, List myData){
        mContext = context;
        mListData = myData;


    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // what should be dispalyed in a row
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView == null){
            // inflate converts a xml layout into whats displayed
            convertView = View.inflate(mContext, R.layout.list_row, null);

            ImageView imageView = convertView.findViewById(R.id.animalImage);
            TextView textView = convertView.findViewById(R.id.textView);
            RelativeLayout nextAndDelBtnRelativeLayout = convertView.findViewById(R.id.nextAndDeleteFactLayout);
            Button nextFactButton = convertView.findViewById(R.id.nextFact);
            Button deleteFactButton = convertView.findViewById(R.id.deleteFact);

            viewHolder = new ViewHolder(imageView, textView, nextAndDelBtnRelativeLayout,
                                        nextFactButton, deleteFactButton);
            //
            convertView.setTag(position);
        }else{
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag(position);

        }

        AnimalListData data = (AnimalListData) getItem(position);

        //ViewHolder viewHolder = (ViewHolder) convertView.getTag();

       /* convertView.findViewById(R.id.color_block).setBackgroundColor(data.mColor);
        ((TextView)convertView.findViewById(R.id.textView)).setText(data.mString);*/

       // int id = Resources.getSystem().getIdentifier("com.example.assignment2/ic_dog", null,null);
        //int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);

        //imageview.setImageResource(id);

        //viewHolder.mImageView.setBackgroundColor(data.mColor);
        //System.out.println(id);

        Context context = viewHolder.mImageView.getContext();
        int id = context.getResources().getIdentifier(data.mDrawableName, "drawable", context.getPackageName());
        //imageView.setImageResource(id);

        viewHolder.mImageView.setImageResource(id);
        viewHolder.mTextView.setText(data.mString);
        viewHolder.mTextView.setVisibility(
               viewHolder.mTextView.getVisibility() == View.VISIBLE? View.VISIBLE : View.INVISIBLE);
        viewHolder.mNextAndDelBtnRelativeLayout.setVisibility(
                viewHolder.mNextAndDelBtnRelativeLayout.getVisibility() == View.VISIBLE? View.VISIBLE: View.INVISIBLE);


        return convertView;
    }

    public static class ViewHolder{
        public ImageView mImageView;
        public TextView mTextView;
        public Button mNextFactButton;
        public Button mDeleteFactButton;
        public RelativeLayout mNextAndDelBtnRelativeLayout;

        public ViewHolder(ImageView imageView, TextView textView, RelativeLayout nextAndDelBtnRelativeLayout,
                          Button nextFactButton, Button deleteFactButton){
            mImageView = imageView;
            mTextView = textView;
            mNextAndDelBtnRelativeLayout = nextAndDelBtnRelativeLayout;
            mNextFactButton = nextFactButton;
            mDeleteFactButton = deleteFactButton;
        }
    }
}
