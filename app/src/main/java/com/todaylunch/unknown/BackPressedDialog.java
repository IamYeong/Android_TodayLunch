package com.todaylunch.unknown;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class BackPressedDialog {

    private Context context;
    private Dialog dialog;
    private ButtonDrawableUtil buttonUtil;
    private int buttonNumber, fontNumber;
    private Button btn_ok, btn_cancel;
    private TextView tv_title;
    private TypefaceUtil typefaceUtil;

    //ca-app-pub-8489601855107344/3448745136
    //test ad id : ca-app-pub-3940256099942544/2247696110


    public BackPressedDialog(Context context) {
        this.context = context;
        buttonUtil = new ButtonDrawableUtil(context);
        typefaceUtil = new TypefaceUtil(context);
        buttonNumber = MainActivity.BACKGROUND_NUMBER;
        fontNumber = MainActivity.FONT_NUMBER;

    }

    public void callBackPressDialog() {

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.backpressed_dialog);

        loadNativeAd();

        dialog.show();

        btn_ok = dialog.findViewById(R.id.btn_backpressed_positive);
        btn_cancel = dialog.findViewById(R.id.btn_backpressed_negative);
        tv_title = dialog.findViewById(R.id.tv_backpress);

        btn_ok.setBackground(buttonUtil.getDrawable(buttonNumber));
        btn_cancel.setBackground(buttonUtil.getDrawable(buttonNumber));
        tv_title.setTypeface(typefaceUtil.getTypeface(fontNumber));

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context ).finish();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private void loadNativeAd() {

        AdLoader.Builder builder = new AdLoader.Builder(context, "ca-app-pub-8489601855107344/3448745136");
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {

                TemplateView templateView = dialog.findViewById(R.id.native_template);
                templateView.setNativeAd(unifiedNativeAd);

            }
        });

        AdLoader adLoader = builder.build();
        AdRequest adRequest = new AdRequest.Builder().build();
        adLoader.loadAd(adRequest);



    }

}
