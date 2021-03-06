package com.octo.android.robospice.sample.ui.spicelist.adapter;

import java.io.File;

import android.content.Context;
import android.view.ViewGroup;

import com.octo.android.robospice.request.simple.BitmapRequest;
import com.octo.android.robospice.sample.ui.spicelist.model.GitHubUser;
import com.octo.android.robospice.sample.ui.spicelist.view.GitHubUserView;
import com.octo.android.robospice.spicelist.BitmapSpiceManager;
import com.octo.android.robospice.spicelist.SpiceArrayAdapter;
import com.octo.android.robospice.spicelist.SpiceListItemView;

/**
 * An example {@link SpiceArrayAdapter}.
 * @author jva
 * @author stp
 * @author sni
 */
public class GitHubUserListAdapter extends SpiceArrayAdapter<GitHubUser> {

    // --------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // --------------------------------------------------------------------------------------------

    public GitHubUserListAdapter(Context context, BitmapSpiceManager spiceManagerBitmap, GitHubUser.List users) {
        super(context, spiceManagerBitmap, users.getUsers());
    }

    @Override
    public BitmapRequest createRequest(GitHubUser gitHubUser, int imageIndex, int requestImageWidth, int requestImageHeight) {
        File tempFile = new File(getContext().getCacheDir(), "THUMB_IMAGE_TEMP_" + gitHubUser.getName());
        return new BitmapRequest("https://secure.gravatar.com/avatar/" + gitHubUser.getGravatar_id(), requestImageWidth,
                requestImageHeight, tempFile);
    }

    @Override
    public SpiceListItemView<GitHubUser> createView(Context context, ViewGroup parent) {
        return new GitHubUserView(getContext());
    }
}
