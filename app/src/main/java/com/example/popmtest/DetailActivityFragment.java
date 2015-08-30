package com.example.popmtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private final String LOG_TAG = DetailActivityFragment.class.getSimpleName();
    private Context mContext;
    private ImageView mPosterView;
    private ImageView mBackdropView;
    private TextView mTitleView;
    private TextView mReleaseView;
    private TextView mVoteView;
    private TextView mOverviewView;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View detailView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        Movie movieObjInToClass = intent.getExtras().getParcelable("myMovieObj");

        if (movieObjInToClass != null) {
            mPosterView = (ImageView) detailView.findViewById(R.id.poster_detail);
            mBackdropView = (ImageView) detailView.findViewById(R.id.backdrop_detail);
            mTitleView = (TextView) detailView.findViewById(R.id.movie_title);
            mReleaseView = (TextView) detailView.findViewById(R.id.movie_release);
            mVoteView = (TextView) detailView.findViewById(R.id.movie_vote);
            mOverviewView = (TextView) detailView.findViewById(R.id.overview);

            String backdropImageUrl = "http://image.tmdb.org/t/p/w342" + movieObjInToClass.getBackdrop();
            Picasso.with(mContext).load(backdropImageUrl).into(mBackdropView);

            String posterImageUrl = "http://image.tmdb.org/t/p/w185" + movieObjInToClass.getPoster();
            Picasso.with(mContext).load(posterImageUrl).into(mPosterView);
            mTitleView.setText(movieObjInToClass.getTitle());
            mReleaseView.setText(movieObjInToClass.getReleaseDate());
            String voteResult = Double.toString(movieObjInToClass.getVote());
            mVoteView.setText(voteResult);
            mOverviewView.setText(movieObjInToClass.getOverview());
        }

        return  detailView;
    }
}
