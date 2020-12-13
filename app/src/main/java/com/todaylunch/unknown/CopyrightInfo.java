package com.todaylunch.unknown;

import android.app.ActionBar;
import android.content.Context;
import android.text.util.Linkify;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyrightInfo {

    private Context mContext;
    private TextView mTextView;
    private String mCopyright, mKeyword, mKeyword2, mLink, mLink2;

    public CopyrightInfo(String copyright, String keyword,  String link, String keyword2, String link2) {

        this.mCopyright = copyright;
        this.mKeyword = keyword;
        this.mKeyword2 = keyword2;
        this.mLink = link;
        this.mLink2 = link2;

    }

    public void setLink(Context context, TextView textView) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5,10,5,5);
        this.mContext = context;

        this.mTextView = textView;

        mTextView.setText(mCopyright);
        mTextView.setLinkTextColor(mContext.getResources().getColor(R.color.link));
        mTextView.setLayoutParams(layoutParams);

        Pattern pattern1 = Pattern.compile(mKeyword);
        Pattern pattern2 = Pattern.compile(mKeyword2);

        Linkify.TransformFilter transformFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Linkify.addLinks(mTextView, pattern1, mLink, null, transformFilter);
        Linkify.addLinks(mTextView, pattern2, mLink2, null, transformFilter);

    }

}
