package com.nikdemo.foodie_susi_restorentui.customui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.nikdemo.foodie_susi_restorentui.Constants;
import com.nikdemo.foodie_susi_restorentui.R;

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {


    private Context mContext;
    private String mFont;

    public CustomEditText(Context context) {
        super(context, null);
        mContext = context;
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView,
                0, 0);
        try {
            mFont = a.getString(R.styleable.CustomTextView_fontName);
        } finally {
            a.recycle();
        }
        init();
    }

    public void init() {
        if (mFont != null) {
            Typeface tf;
            if (mFont.equals(mContext.getString(R.string.font_lato_bold))) {
                tf = Typeface.createFromAsset(mContext.getAssets(), Constants.sourceLatoBold);
            } else if (mFont.equals(mContext.getString(R.string.font_lato_regular))) {
                tf = Typeface.createFromAsset(mContext.getAssets(), Constants.sourceLatoRegular);
            } else if (mFont.equals(mContext.getString(R.string.font_titillium_bold))) {
                tf = Typeface.createFromAsset(mContext.getAssets(), Constants.sourceTitilliumBold);
            } else {
                tf = Typeface.createFromAsset(mContext.getAssets(), Constants.sourceTitilliumRegular);
            }

            setTypeface(tf, Typeface.NORMAL);
        }
    }
}
