package com.example.popmtest;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Victor Cordero.
 */
public class Movie implements Parcelable {

    private int id;
    private String title;
    private String poster;
    private String backdrop;
    private Double vote;
    private String overview;
    private String releaseDate;

    public Movie() {
    }

    public Movie(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.title = movie.getString("original_title");
        this.poster = movie.getString("poster_path");
        this.backdrop = movie.getString("backdrop_path");
        this.vote = movie.getDouble("vote_average");
        this.overview = movie.getString("overview");
        this.releaseDate = movie.getString("release_date");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public Double getVote() {
        return vote;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(poster);
        dest.writeString(backdrop);
        dest.writeDouble(vote);
        dest.writeString(overview);
        dest.writeString(releaseDate);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private Movie(Parcel source) {
        id = source.readInt();
        title = source.readString();
        poster = source.readString();
        backdrop = source.readString();
        vote = source.readDouble();
        overview = source.readString();
        releaseDate = source.readString();
    }
}