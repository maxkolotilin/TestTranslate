package com.karanchuk.roman.testtranslate.favorites;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.karanchuk.roman.testtranslate.R;
import com.karanchuk.roman.testtranslate.data.TranslatedItem;

import java.util.ArrayList;

/**
 * Created by roman on 9.4.17.
 */

public class FavoritesRecyclerAdapter extends RecyclerView.Adapter<FavoritesRecyclerAdapter.ViewHolder>{
    public interface OnItemClickListener {
        void onItemClick(TranslatedItem item);
    }

    private final ArrayList<TranslatedItem> mItems;
    private final OnItemClickListener mListener;

    public FavoritesRecyclerAdapter(ArrayList<TranslatedItem> items, OnItemClickListener listener){
        mItems = items;
        mListener = listener;
    }

    @Override
    public FavoritesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.content_favorite_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mItems.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIsFavoriteView;
        private TextView mSrcLanguage, mTrgLanguage,
                        mSrcMeaning, mTrgMeaning;
        private View mView;

        public ViewHolder(View view){
            super(view);
            mView = view;
            mIsFavoriteView = (ImageView) view.findViewById(R.id.image_favorite);
            mSrcLanguage = (TextView) view.findViewById(R.id.src_language);
            mTrgLanguage = (TextView) view.findViewById(R.id.trg_meaning);
            mSrcMeaning = (TextView) view.findViewById(R.id.src_meaning);
            mTrgMeaning = (TextView) view.findViewById(R.id.trg_meaning);
        }

        public void bind(final TranslatedItem item, final OnItemClickListener listener){
            if (item.isFavorite()){
            } else {
            }
            mSrcLanguage.setText(item.getSrcLanguage());
            mTrgLanguage.setText(item.getTrgLanguage());
            mSrcMeaning.setText(item.getSrcMeaning());
            mTrgMeaning.setText(item.getTrgMeaning());

            mView.setOnClickListener(new View.OnClickListener(){
               @Override public void onClick(View v){
                   listener.onItemClick(item);
               }
            });

        }
    }
}
