package br.com.flip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.flip.connect.*;
import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import static br.com.flip.BuildConfig.MERCHANT_KEY;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Flip.initalize(MERCHANT_KEY);
  }
}
