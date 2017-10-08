package ng.hotels.android.app.ui.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import butterknife.BindView;
import ng.hotels.android.app.R;

public class ReviewStayActivity extends Activity {

    @BindView(R.id.review_image)
    ImageView imageView;
    @BindView(R.id.toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_stay);

            collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
            collapsingToolbarLayout.setTitle("Beni Hotel and Suites");
            imageView = (ImageView) collapsingToolbarLayout.findViewById(R.id.review_image);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.placeholder)
                .showImageForEmptyUri(R.mipmap.placeholder)
                .showImageOnFail(R.mipmap.placeholder)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        String imageUrl = "http://res.cloudinary.com/princessdee/image/upload/v1507222599/image_5_j0mwty.png";
        imageLoader.displayImage(imageUrl,imageView,options);
    }
}
